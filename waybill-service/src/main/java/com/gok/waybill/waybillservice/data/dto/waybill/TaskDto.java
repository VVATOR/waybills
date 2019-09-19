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
public class TaskDto extends Dto {

    private String customer;

    private LocalDate dateArriving;

    private LocalDate dateDeparture;

    private String departurePoint;

    private String destinationPoint;

    private String cargo;

    public TaskDto() {
        super();
    }
}
