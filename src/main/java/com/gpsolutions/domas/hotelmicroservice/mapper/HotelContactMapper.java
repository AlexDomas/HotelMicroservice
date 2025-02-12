package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelContactDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.HotelContact;
import org.springframework.stereotype.Component;

@Component
public class HotelContactMapper {

    public HotelContact maptoHotelContact(HotelContactDTO hotelContactDTO) {
        return new HotelContact(hotelContactDTO.getPhone(), hotelContactDTO.getEmail());
    }

    public HotelContactDTO mapToHotelContactDTO(HotelContact hotelContact) {
        return new HotelContactDTO(hotelContact.getPhone(), hotelContact.getEmail());
    }

}
