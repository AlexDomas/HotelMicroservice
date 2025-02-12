package com.gpsolutions.domas.hotelmicroservice.service;

import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.request.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.UpdatedHistogramResponseDTO;

import java.util.List;

public interface HotelService {

    HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO);

    List<HotelSummaryResponseDTO> getAllHotels();

    HotelDetailResponseDTO getHotelById(Long id);

    List<HotelSummaryResponseDTO> searchHotels(String name, String brand, String city, String county, List<String> amenities);

    HotelDetailResponseDTO addAmenitiesToHotel(Long id, List<String> amenities);

    UpdatedHistogramResponseDTO getHistogram(String parameter);

}
