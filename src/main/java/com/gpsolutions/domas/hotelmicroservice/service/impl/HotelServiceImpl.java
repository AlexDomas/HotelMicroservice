package com.gpsolutions.domas.hotelmicroservice.service.impl;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import com.gpsolutions.domas.hotelmicroservice.mapper.HotelMapper;
import com.gpsolutions.domas.hotelmicroservice.repository.HotelRepository;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    @Transactional
    @Override
    public HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelMapper.mapToHotel(hotelRequestDTO);
        hotelRepository.save(hotel);
        return hotelMapper.mapToHotelResponseDTO(hotel);
    }

}
