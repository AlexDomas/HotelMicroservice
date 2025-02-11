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
import java.util.Map;

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
    public ResponseEntity<HotelDetailResponseDTO> getHotelById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HotelSummaryResponseDTO>> searchHotels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String county,
            @RequestParam(required = false) List<String> amenities)
    {
        return ResponseEntity.ok(hotelService.searchHotels(name, brand, city, county, amenities));
    }

    @GetMapping("/histogram/{param}")
    public ResponseEntity<Map<String, Integer>> getHotelHistogram(@PathVariable String param){
        return ResponseEntity.ok(hotelService.getHistogram(param));
    }

    @PostMapping("/{id}/amenities")
    public ResponseEntity<HotelDetailResponseDTO> addAmenitiesToHotel(@PathVariable Long id, @RequestBody List<String> amenities){
        return ResponseEntity.ok(hotelService.addAmenitiesToHotel(id, amenities));
    }

    @PostMapping
    public ResponseEntity<HotelSummaryResponseDTO> createTransaction(@RequestBody HotelRequestDTO hotelRequestDTO){
        return new ResponseEntity<>(hotelService.createHotel(hotelRequestDTO), HttpStatus.CREATED);
    }

}
