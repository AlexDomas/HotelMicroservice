package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.request.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HotelMapper {

    private final HotelAddressMapper hotelAddressMapper;

    private final HotelContactMapper hotelContactMapper;

    private final HotelArrivalTimeMapper hotelArrivalTimeMapper;

    public Hotel mapToHotel(HotelRequestDTO hotelRequestDTO) {
        return new Hotel(hotelRequestDTO.getName(),
                hotelRequestDTO.getDescription(),
                hotelRequestDTO.getBrand(),
                hotelAddressMapper.mapToHotelAddress(hotelRequestDTO.getAddress()),
                hotelContactMapper.maptoHotelContact(hotelRequestDTO.getContact()),
                hotelArrivalTimeMapper.mapToHotelArrivalTime(hotelRequestDTO.getArrivalTime()),
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
                hotelAddressMapper.mapToHotelAddressDTO(hotel.getAddress()),
                hotelContactMapper.mapToHotelContactDTO(hotel.getContact()),
                hotelArrivalTimeMapper.mapToHotelArrivalTimeDTO(hotel.getArrivalTime()),
                hotel.getAmenities()
        );
    }

}
