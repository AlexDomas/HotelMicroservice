package com.gpsolutions.domas.hotelmicroservice.mapper;

import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelArrivalTimeDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.HotelArrivalTime;
import org.springframework.stereotype.Component;

@Component
public class HotelArrivalTimeMapper {

    public HotelArrivalTime mapToHotelArrivalTime(HotelArrivalTimeDTO hotelArrivalTimeDTO) {
        return new HotelArrivalTime(hotelArrivalTimeDTO.getCheckIn(), hotelArrivalTimeDTO.getCheckOut());
    }

    public HotelArrivalTimeDTO mapToHotelArrivalTimeDTO(HotelArrivalTime hotelArrivalTime) {
        return new HotelArrivalTimeDTO(hotelArrivalTime.getCheckIn(), hotelArrivalTime.getCheckOut());
    }

}
