package com.gpsolutions.domas.hotelmicroservice.rest;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/property-view/hotels")
@RestController
public class HotelRestController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelSummaryResponseDTO> createTransaction(@RequestBody HotelRequestDTO hotelRequestDTO){
        return new ResponseEntity<>(hotelService.createHotel(hotelRequestDTO), HttpStatus.CREATED);
    }

}
