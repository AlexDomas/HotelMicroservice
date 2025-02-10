package com.gpsolutions.domas.hotelmicroservice.advice;

import com.gpsolutions.domas.hotelmicroservice.exception.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HotelRestControllerAdvice {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handleHotelNotFoundException(final HotelNotFoundException e) {
        log.error("An exception occurred! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
