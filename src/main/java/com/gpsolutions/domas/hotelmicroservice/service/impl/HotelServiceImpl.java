package com.gpsolutions.domas.hotelmicroservice.service.impl;

import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.request.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.UpdatedHistogramResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import com.gpsolutions.domas.hotelmicroservice.exception.HotelNotFoundException;
import com.gpsolutions.domas.hotelmicroservice.exception.NoSuchParameterFoundException;
import com.gpsolutions.domas.hotelmicroservice.filter.HotelFilter;
import com.gpsolutions.domas.hotelmicroservice.mapper.HotelMapper;
import com.gpsolutions.domas.hotelmicroservice.repository.HotelRepository;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    private final HotelFilter hotelFilter;

    @Override
    public HotelDetailResponseDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("The hotel with id " + id + " does not exist."));
        return hotelMapper.mapToHotelDetailResponseDTO(hotel);
    }

    @Override
    public List<HotelSummaryResponseDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::mapToHotelSummaryResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelSummaryResponseDTO> searchHotels(String name, String brand, String city, String county, List<String> amenities) {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .filter(hotelFilter.createFilter(name, brand, city, county, amenities))
                .map(hotelMapper::mapToHotelSummaryResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public HotelDetailResponseDTO addAmenitiesToHotel(Long id, List<String> amenities) {
        Hotel hotelForUpdateAmenities = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("The hotel with id " + id + " does not exist."));
        amenities.forEach(newAmenity -> updateOrAddAmenity(hotelForUpdateAmenities, newAmenity));
        hotelRepository.save(hotelForUpdateAmenities);
        return hotelMapper.mapToHotelDetailResponseDTO(hotelForUpdateAmenities);
    }

    private void updateOrAddAmenity(Hotel hotel, String newAmenity) {
        if (hotel.getAmenities().contains(newAmenity)) {
            hotel.getAmenities().set(hotel.getAmenities().indexOf(newAmenity), newAmenity);
        } else {
            hotel.getAmenities().add(newAmenity);
        }
    }

    @Override
    public UpdatedHistogramResponseDTO getHistogram(String parameter) {
        List<Hotel> hotels = hotelRepository.findAll();
        Map<String, Integer> histogram = new HashMap<>();
        for (Hotel hotel : hotels) {
            switch (parameter) {
                case "brand":
                    updateHistogram(histogram, hotel.getBrand());
                    break;
                case "city":
                    updateHistogram(histogram, hotel.getAddress().getCity());
                    break;
                case "county":
                    updateHistogram(histogram, hotel.getAddress().getCounty());
                    break;
                case "amenities":
                    hotel.getAmenities().forEach(amenity -> updateHistogram(histogram, amenity));
                    break;
                default:
                    throw new NoSuchParameterFoundException("Invalid parameter: " + parameter);
            }
        }
        return new UpdatedHistogramResponseDTO(histogram);
    }

    private void updateHistogram(Map<String, Integer> histogram, String key) {
        if (key != null && !key.isEmpty()) {
            histogram.put(key, histogram.getOrDefault(key, 0) + 1);
        }
    }

    @Transactional
    @Override
    public HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelMapper.mapToHotel(hotelRequestDTO);
        hotelRepository.save(hotel);
        return hotelMapper.mapToHotelSummaryResponseDTO(hotel);
    }

}
