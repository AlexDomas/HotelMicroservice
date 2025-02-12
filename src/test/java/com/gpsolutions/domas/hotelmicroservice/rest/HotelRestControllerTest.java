package com.gpsolutions.domas.hotelmicroservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelAddressDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelArrivalTimeDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelContactDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.request.HotelRequestDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelDetailResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.HotelSummaryResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.response.UpdatedHistogramResponseDTO;
import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import com.gpsolutions.domas.hotelmicroservice.service.HotelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("test")
public class HotelRestControllerTest {

    @SuppressWarnings(value = "all")
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HotelService hotelService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createHotel_CheckingCreatingHotel_ShouldReturnHotelSummaryResponseDTO() throws Exception {
        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO("Hilton", "Test description", "Anonimus",
                new HotelAddressDTO(9, "Valueva", "Minsk", "Belarus", "321333"),
                new HotelContactDTO("+375 44 333-33-33", "alexgusto@mail.ru"),
                new HotelArrivalTimeDTO("12:00", "14:00"), null);

        when(hotelService.createHotel(hotelRequestDTO)).thenReturn(
                new HotelSummaryResponseDTO(1L, hotelRequestDTO.getName(), hotelRequestDTO.getDescription(),
                new StringBuilder()
                .append(hotelRequestDTO.getAddress().getHouseNumber()).append(" ")
                .append(hotelRequestDTO.getAddress().getStreet()).append(", ")
                .append(hotelRequestDTO.getAddress().getCity()).append(", ")
                .append(hotelRequestDTO.getAddress().getPostCode()).append(", ")
                .append(hotelRequestDTO.getAddress().getCounty()).toString(),
                hotelRequestDTO.getContact().getPhone()));

        mockMvc.perform(post("/property-view/hotels")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(hotelRequestDTO)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllHotels_CheckingForGettingAllHotels_ShouldReturnStatusOK() throws Exception {
        this.mockMvc.perform(get("/property-view/hotels"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getHotelById_ShouldReturnHotelDetailResponseDTO_WhenHotelExists() throws Exception {
        Long hotelId = 1L;
        HotelDetailResponseDTO hotelDetailResponseDTO = hotelService.getHotelById(hotelId);
        when(hotelService.getHotelById(hotelId)).thenReturn(hotelDetailResponseDTO);
        mockMvc.perform(get("/property-view/hotels/{id}", hotelId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    public void searchHotels_ShouldReturnListOfHotelSummaryResponseDTO_WhenHotelsFound() throws Exception {
        String name = "DoubleTree by Hilton Minsk";
        String brand = "Hilton";
        String city = "Minsk";
        String county = "Belarus";
        List<HotelSummaryResponseDTO> hotelSummaryResponseDTOList = hotelService.searchHotels(name, brand, city, county, null);

        when(hotelService.searchHotels(name, brand, city, county, null)).thenReturn(hotelSummaryResponseDTOList);

        mockMvc.perform(get("/property-view/hotels/search")
                        .param("name", name)
                        .param("brand", brand)
                        .param("city", city)
                        .param("county", county)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    public void getHotelHistogram_ShouldReturnUpdatedHistogramResponseDTO_WhenParamIsValid() throws Exception {
        String param = "city";
        UpdatedHistogramResponseDTO responseDTO = hotelService.getHistogram(param);
        when(hotelService.getHistogram(param)).thenReturn(responseDTO);
        mockMvc.perform(get("/property-view/hotels/histogram/{param}", param)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    public void addAmenitiesToHotel_ShouldReturnHotelDetailResponseDTO_WhenAmenitiesAddedSuccessfully() throws Exception {
        Long hotelId = 1L;
        List<String> amenities = Arrays.asList("Free WiFi", "Pool");
        HotelDetailResponseDTO responseDTO = hotelService.addAmenitiesToHotel(hotelId, amenities);
        when(hotelService.addAmenitiesToHotel(hotelId, amenities)).thenReturn(responseDTO);
        mockMvc.perform(post("/property-view/hotels/{id}/amenities", hotelId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(amenities)))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

}
