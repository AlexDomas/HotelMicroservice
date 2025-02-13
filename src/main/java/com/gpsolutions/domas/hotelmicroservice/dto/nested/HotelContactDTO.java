package com.gpsolutions.domas.hotelmicroservice.dto.nested;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.gpsolutions.domas.hotelmicroservice.constant.MessageErrorHotelConstant.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelContactDTO {

    @NotNull(message = MESSAGE_ERROR_FIELD_PHONE_NUMBER_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_PHONE_NUMBER_NOT_BLANK)
    @Pattern(regexp = "^\\+375 \\d{2} \\d{3}-\\d{2}-\\d{2}$", message = MESSAGE_ERROR_FIELD_PHONE_NUMBER_PATTERN)
    private String phone;

    @NotNull(message = MESSAGE_ERROR_FIELD_EMAIL_NOT_NULL)
    @NotBlank(message = MESSAGE_ERROR_FIELD_EMAIL_NOT_BLANK)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = MESSAGE_ERROR_FIELD_EMAIL_PATTERN)
    @Size(min = 7, max = 50, message = MESSAGE_ERROR_FIELD_EMAIL_NOT_IN_RANGE)
    private String email;

}
