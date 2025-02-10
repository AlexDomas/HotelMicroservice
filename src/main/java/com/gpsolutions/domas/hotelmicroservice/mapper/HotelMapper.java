package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelDetailResponseDTO;
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

    public HotelSummaryResponseDTO mapToHotelSummaryResponseDTO(Hotel hotel) {
        return new HotelSummaryResponseDTO(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                new StringBuilder()
                        .append(hotel.getAddress().getHouseNumber()).append(" ")
                        .append(hotel.getAddress().getStreet()).append(", ")
                        .append(hotel.getAddress().getCity()).append(", ")
                        .append(hotel.getAddress().getPostCode()).append(", ")
                        .append(hotel.getAddress().getCounty()).toString(),
                hotel.getContact().getPhone()
        );
    }

    public HotelDetailResponseDTO mapToHotelDetailResponseDTO(Hotel hotel){
        return new HotelDetailResponseDTO(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getBrand(),
                hotel.getAddress(),
                hotel.getContact(),
                hotel.getArrivalTime(),
                hotel.getAmenities()
        );
    }

}
