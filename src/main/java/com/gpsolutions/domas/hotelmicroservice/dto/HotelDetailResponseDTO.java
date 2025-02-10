package com.gpsolutions.domas.hotelmicroservice.dto;

import com.gpsolutions.domas.hotelmicroservice.entity.ArrivalHotelTime;
import com.gpsolutions.domas.hotelmicroservice.entity.HotelAddress;
import com.gpsolutions.domas.hotelmicroservice.entity.HotelContact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDetailResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String brand;

    private HotelAddress address;

    private HotelContact contact;

    private ArrivalHotelTime arrivalTime;

    private List<String> amenities;

}
