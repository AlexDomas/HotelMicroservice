package com.gpsolutions.domas.hotelmicroservice.service;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;

import java.util.List;
import java.util.Map;

public interface HotelService {

    HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO);

    List<HotelSummaryResponseDTO> getAllHotels();

    HotelDetailResponseDTO getHotelById(Long id);

    List<HotelSummaryResponseDTO> searchHotels(String name, String brand, String city, String county, List<String> amenities);

    HotelDetailResponseDTO addAmenitiesToHotel(Long id, List<String> amenities);

    Map<String, Integer> getHistogram(String parameter);

}
