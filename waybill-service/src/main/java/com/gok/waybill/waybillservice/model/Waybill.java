package com.gok.waybill.waybillservice.model;


import com.gok.waybill.waybillservice.model.constants.Status;
import com.gok.waybill.waybillservice.model.waybill.*;
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
@Table(name="waybill")
public class Waybill extends Model {

    private Status status = Status.ACTIVE;

    @Column
    private String number;

    @Column
    private Date date;

    @OneToOne
    private Driver driver;

    @OneToOne
    private Machine machine;

    @OneToOne
    private Task task;

    @OneToOne
    private WorkDriverAndMachine workDriverAndMachine;

    @OneToOne
    private Result result;

    @OneToOne
    private TSM tsm;

    public Waybill() {
    }
}
