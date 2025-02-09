package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel mapToHotel(HotelRequestDTO hotelRequestDTO) {
        return new Hotel(hotelRequestDTO.getName(),
                hotelRequestDTO.getDescription(),
                hotelRequestDTO.getBrand(),
                hotelRequestDTO.getAddress(),
                hotelRequestDTO.getContact(),
                hotelRequestDTO.getArrivalTime(),
                hotelRequestDTO.getAmenities()
        );
    }

    public HotelSummaryResponseDTO mapToHotelResponseDTO(Hotel hotel) {
        return new HotelSummaryResponseDTO(
                hotel.getName(),
                hotel.getDescription(),
                hotel.getAddress().getHouseNumber() + hotel.getAddress().getStreet() + hotel.getAddress().getCity() + hotel.getAddress().getPostCode() + hotel.getAddress().getCounty(),
                hotel.getContact().getPhone()
        );
    }
}
