package com.gok.waybill.waybillservice.data.dto.waybill;


import com.gok.waybill.waybillservice.data.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TsmDto extends Dto {

    private LocalDate fuelingDate;

    private String fuelType;

    private Integer amountOfFuel;

    private Integer startedAmountOfFuel;

    private Integer finalAmountOfFuel;


    public TsmDto() {
    }
}
