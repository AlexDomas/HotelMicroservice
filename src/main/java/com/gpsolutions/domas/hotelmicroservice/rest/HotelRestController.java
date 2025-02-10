package com.gpsolutions.domas.hotelmicroservice.rest;

import com.gpsolutions.domas.hotelmicroservice.dto.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/property-view/hotels")
@RestController
public class HotelRestController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelSummaryResponseDTO>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDetailResponseDTO> getHotelById(@PathVariable("id") Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @PostMapping
    public ResponseEntity<HotelSummaryResponseDTO> createTransaction(@RequestBody HotelRequestDTO hotelRequestDTO){
        return new ResponseEntity<>(hotelService.createHotel(hotelRequestDTO), HttpStatus.CREATED);
    }

}
