package com.gok.waybill.waybillservice.data.model.waybill;


import com.gok.waybill.waybillservice.data.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "tsm")
public class TSM extends Model {
    private Date fuelingDate;
    private String fuelType;
    private Integer amountOfFuel;
    private Integer startedAmountOfFuel;
    private Integer finalAmountOfFuel;

    public TSM() {
    }
}