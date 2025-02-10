package com.gpsolutions.domas.hotelmicroservice.service.impl;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import com.gpsolutions.domas.hotelmicroservice.exception.HotelNotFoundException;
import com.gpsolutions.domas.hotelmicroservice.mapper.HotelMapper;
import com.gpsolutions.domas.hotelmicroservice.repository.HotelRepository;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

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


    @Transactional
    @Override
    public HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelMapper.mapToHotel(hotelRequestDTO);
        hotelRepository.save(hotel);
        return hotelMapper.mapToHotelSummaryResponseDTO(hotel);
    }



}
