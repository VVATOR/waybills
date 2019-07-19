package com.gok.waybill.waybillservice.model;


import com.gok.waybill.waybillservice.model.constants.Status;
import com.gok.waybill.waybillservice.model.waybill.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Waybill extends Model {

    private Status status = Status.ACTIVE;

    private String number;
    private Date date;

    private Driver driver;
    private Machine machine;
    private Task task;
    private WorkDriverAndMachine workDriverAndMachine;
    private Result result;
    private TSM tsm;

    public Waybill() {
    }
}
