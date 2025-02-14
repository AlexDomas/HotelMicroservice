package com.gpsolutions.domas.hotelmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hotel_contact")
public class HotelContact extends BaseEntity {

    private String phone;

    private String email;

}
