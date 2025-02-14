package com.gpsolutions.domas.hotelmicroservice.advice;

import com.gpsolutions.domas.hotelmicroservice.exception.HotelNotFoundException;
import com.gpsolutions.domas.hotelmicroservice.exception.NoSuchParameterFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HotelRestControllerAdvice {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String> handleHotelNotFoundException(final HotelNotFoundException e) {
        log.error("An exception occurred! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchParameterFoundException.class)
    public ResponseEntity<String> handleNoSuchParameterFoundException(final NoSuchParameterFoundException e) {
        log.error("An exception occurred! ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
