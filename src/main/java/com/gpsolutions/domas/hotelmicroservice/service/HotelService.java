package com.gpsolutions.domas.hotelmicroservice.service;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;

import java.util.List;

public interface HotelService {

    HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO);

    List<HotelSummaryResponseDTO> getAllHotels();

    HotelDetailResponseDTO getHotelById(Long id);

}
