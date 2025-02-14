package com.gpsolutions.domas.hotelmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hotel_address")
public class HotelAddress extends BaseEntity {

    private int houseNumber;

    private String street;

    private String city;

    private String county;

    private String postCode;

}
