package com.gpsolutions.domas.hotelmicroservice.rest;

import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.request.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.UpdatedHistogramResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Api(description = "Endpoint which helps us to get information about hotels, " +
                    "add hotel, amenities, " +
                    "search for information by parameter, " +
                    "get grouped histogram by parameter.")
@RestController
@RequestMapping("/property-view/hotels")
public class HotelRestController {

    private final HotelService hotelService;

    @Autowired
    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ApiOperation(value = "Api for getting all hotels")
    @ApiResponse(code = 200, response = HotelSummaryResponseDTO.class, message = "OK")
    @GetMapping
    public ResponseEntity<List<HotelSummaryResponseDTO>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @ApiOperation(value = "Api for getting the hotel by id")
    @ApiResponse(code = 200, response = HotelDetailResponseDTO.class, message = "OK")
    @GetMapping("/{id}")
    public ResponseEntity<HotelDetailResponseDTO> getHotelById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @ApiOperation(value = "Api for searching hotels by parameter (name, brand, city, county, amenities)")
    @ApiResponse(code = 200, response = HotelSummaryResponseDTO.class, message = "OK")
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

    @ApiOperation(value = "Api for getting histogram by parameter (brand, city, county, amenities)")
    @ApiResponse(code = 200, response = UpdatedHistogramResponseDTO.class, message = "OK")
    @GetMapping("/histogram/{param}")
    public ResponseEntity<UpdatedHistogramResponseDTO> getHotelHistogram(@PathVariable String param){
        return ResponseEntity.ok(hotelService.getHistogram(param));
    }

    @ApiOperation(value = "Add amenities to some hotel", notes = "This API add amenities to hotel by id")
    @ApiResponse(code = 200, response = HotelDetailResponseDTO.class, message = "Amenities added successfully")
    @PostMapping("/{id}/amenities")
    public ResponseEntity<HotelDetailResponseDTO> addAmenitiesToHotel(@PathVariable Long id, @RequestBody List<String> amenities){
        return ResponseEntity.ok(hotelService.addAmenitiesToHotel(id, amenities));
    }

    @ApiOperation(value = "Create a new hotel", notes = "This API creates a new hotel")
    @ApiResponse(code = 201, response = HotelSummaryResponseDTO.class, message = "The hotel created successfully")
    @PostMapping
    public ResponseEntity<HotelSummaryResponseDTO> createHotel(@RequestBody @Valid HotelRequestDTO hotelRequestDTO){
        return new ResponseEntity<>(hotelService.createHotel(hotelRequestDTO), HttpStatus.CREATED);
    }

}
