package com.gok.waybill.waybillservice.model;


import com.gok.waybill.waybillservice.model.waybill.Result;
import com.gok.waybill.waybillservice.model.waybill.TSM;
import com.gok.waybill.waybillservice.model.waybill.Task;
import com.gok.waybill.waybillservice.model.waybill.WorkDriverAndMachine;
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
