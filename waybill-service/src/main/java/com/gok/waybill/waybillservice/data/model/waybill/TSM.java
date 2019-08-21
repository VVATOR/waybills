package com.gok.waybill.waybillservice.data.model.waybill;


import com.gok.waybill.waybillservice.data.model.Model;
import com.gok.waybill.waybillservice.data.model.Waybill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "tsm")
public class TSM extends Model {

    //private Date fuelingDate;

    @Column(name="fuel_type")
    private String fuelType;

    @Column(name="amount_of_fuel")
    private Integer amountOfFuel;

    @Column(name="started_amount_of_fuel")
    private Integer startedAmountOfFuel;

    @Column(name="final_amount_of_fuel")
    private Integer finalAmountOfFuel;

    @OneToOne(optional = false, mappedBy = "tsm")
    private Waybill waybill;

    public TSM() {
    }
}
