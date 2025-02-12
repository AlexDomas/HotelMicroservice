package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelAddressDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.HotelAddress;
import org.springframework.stereotype.Component;

@Component
public class HotelAddressMapper {

    public HotelAddress mapToHotelAddress(HotelAddressDTO hotelAddressDTO) {
        return new HotelAddress(
                hotelAddressDTO.getHouseNumber(),
                hotelAddressDTO.getStreet(),
                hotelAddressDTO.getCity(),
                hotelAddressDTO.getCounty(),
                hotelAddressDTO.getPostCode()
        );
    }

    public HotelAddressDTO mapToHotelAddressDTO(HotelAddress hotelAddress) {
        return new HotelAddressDTO(
                hotelAddress.getHouseNumber(),
                hotelAddress.getStreet(),
                hotelAddress.getCity(),
                hotelAddress.getCounty(),
                hotelAddress.getPostCode()
        );
    }

}
