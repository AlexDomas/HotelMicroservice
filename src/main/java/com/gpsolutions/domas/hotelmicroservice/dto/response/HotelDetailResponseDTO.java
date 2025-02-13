package com.gpsolutions.domas.hotelmicroservice.dto.response;

import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelAddressDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelArrivalTimeDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelContactDTO;
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

    private HotelAddressDTO address;

    private HotelContactDTO contact;

    private HotelArrivalTimeDTO arrivalTime;

    private List<String> amenities;

}
