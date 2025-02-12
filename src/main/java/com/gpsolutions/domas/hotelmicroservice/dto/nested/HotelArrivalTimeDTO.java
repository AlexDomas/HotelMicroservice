package com.gpsolutions.domas.hotelmicroservice.dto.nested;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.gpsolutions.domas.hotelmicroservice.constant.MessageErrorHotelConstant.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelArrivalTimeDTO {

    @NotNull(message = MESSAGE_ERROR_FIELD_CHECKIN_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_CHECKIN_NOT_BLANK)
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = MESSAGE_ERROR_FIELD_CHECKIN_PATTERN)
    private String checkIn;

    @NotNull(message = MESSAGE_ERROR_FIELD_CHECKOUT_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_CHECKOUT_NOT_BLANK)
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = MESSAGE_ERROR_FIELD_CHECKOUT_PATTERN)
    private String checkOut;

}
