package com.gpsolutions.domas.hotelmicroservice.dto.request;

import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelAddressDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelArrivalTimeDTO;
import com.gpsolutions.domas.hotelmicroservice.dto.nested.HotelContactDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

import static com.gpsolutions.domas.hotelmicroservice.constant.MessageErrorHotelConstant.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelRequestDTO {

    @NotNull(message = MESSAGE_ERROR_HOTEL_FIELD_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_HOTEL_FIELD_NOT_BLANK)
    @Size(min = 5, max = 30, message = MESSAGE_ERROR_HOTEL_FIELD_NOT_IN_RANGE)
    private String name;

    @NotNull(message = MESSAGE_ERROR_HOTEL_DESCRIPTION_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_HOTEL_DESCRIPTION_NOT_BLANK)
    @Size(min = 5, max = 255, message = MESSAGE_ERROR_HOTEL_DESCRIPTION_NOT_IN_RANGE)
    private String description;

    @NotNull(message = MESSAGE_ERROR_HOTEL_BRAND_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_HOTEL_BRAND_NOT_BLANK)
    @Size(min = 5, max = 30, message = MESSAGE_ERROR_HOTEL_BRAND_NOT_IN_RANGE)
    private String brand;

    @NotNull(message = MESSAGE_ERROR_ADDRESS_NOT_NULL)
    private HotelAddressDTO address;

    @NotNull(message = MESSAGE_ERROR_CONTACT_NOT_NULL)
    private HotelContactDTO contact;

    @NotNull(message = MESSAGE_ERROR_ARRIVAL_TIME_NOT_NULL)
    private HotelArrivalTimeDTO arrivalTime;

    private List<String> amenities;

}
