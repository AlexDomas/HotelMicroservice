package com.gpsolutions.domas.hotelmicroservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedHistogramResponseDTO {

    private Map<String, Integer> histogram;

}
