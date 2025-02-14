package com.gpsolutions.domas.hotelmicroservice.dto.nested;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

import static com.gpsolutions.domas.hotelmicroservice.constant.MessageErrorHotelConstant.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelAddressDTO {

    @NotNull(message = MESSAGE_ERROR_FIELD_HOUSE_NUMBER_NOT_NULL)
    @Positive(message = MESSAGE_ERROR_FIELD_HOUSE_NUMBER_NOT_BLANK)
    private int houseNumber;

    @NotNull(message = MESSAGE_ERROR_FIELD_STREET_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_STREET_NOT_BLANK)
    @Size(min = 7, max = 40, message = MESSAGE_ERROR_FIELD_STREET_NOT_IN_RANGE)
    private String street;

    @NotNull(message = MESSAGE_ERROR_FIELD_CITY_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_CITY_NOT_BLANK)
    @Size(min = 3, max = 20, message = MESSAGE_ERROR_FIELD_CITY_NOT_IN_RANGE)
    private String city;

    @NotNull(message = MESSAGE_ERROR_FIELD_COUNTY_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_COUNTY_NOT_BLANK)
    @Size(min = 5, max = 20, message = MESSAGE_ERROR_FIELD_COUNTY_NOT_IN_RANGE)
    private String county;

    @NotNull(message = MESSAGE_ERROR_FIELD_POST_CODE_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_POST_CODE_NOT_BLANK)
    @Pattern(regexp = "\\d{6}", message = MESSAGE_ERROR_FIELD_POST_CODE_PATTERN)
    private String postCode;

}
