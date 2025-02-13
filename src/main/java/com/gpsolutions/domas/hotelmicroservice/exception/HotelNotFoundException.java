package com.gpsolutions.domas.hotelmicroservice.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String message) {
        super(message);
    }

}
