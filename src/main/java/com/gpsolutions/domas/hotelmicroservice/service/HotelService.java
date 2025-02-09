package com.gpsolutions.domas.hotelmicroservice.service;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;

public interface HotelService {

    HotelSummaryResponseDTO createHotel(HotelRequestDTO hotelRequestDTO);

}
