package com.gok.waybill.waybillservice.model.waybill;


import com.gok.waybill.waybillservice.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TSM extends Model {
    private Date fuelingDate;
    private String fuelType;
    private Integer amountOfFuel;
    private Integer startedAmountOfFuel;
    private Integer finalAmountOfFuel;

    public TSM() {
    }
}
