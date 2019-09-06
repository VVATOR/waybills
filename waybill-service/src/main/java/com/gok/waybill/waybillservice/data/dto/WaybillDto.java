package com.gok.waybill.waybillservice.data.dto;


import com.gok.waybill.waybillservice.constants.Status;
import com.gok.waybill.waybillservice.data.dto.waybill.ResultDto;
import com.gok.waybill.waybillservice.data.dto.waybill.TaskDto;
import com.gok.waybill.waybillservice.data.dto.waybill.TsmDto;
import com.gok.waybill.waybillservice.data.dto.waybill.WorkDriverAndMachineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WaybillDto extends Dto {

    private Status status = Status.ACTIVE;

    private String number;

    private LocalDate date;

    private MachineDto machine;

    private Collection<DriverDto> drivers;

    private TaskDto task;

    private WorkDriverAndMachineDto workDriverAndMachine;

    private ResultDto result;

    private TsmDto tsm;

    public WaybillDto() {
        super();
    }
}
