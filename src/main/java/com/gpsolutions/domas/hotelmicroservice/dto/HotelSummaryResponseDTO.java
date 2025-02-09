package com.gpsolutions.domas.hotelmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelSummaryResponseDTO {

    private String name;

    private String description;

    private String address;

    private String phone;

}
