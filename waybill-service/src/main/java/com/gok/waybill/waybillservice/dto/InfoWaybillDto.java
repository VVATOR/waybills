package com.gok.waybill.waybillservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class InfoWaybillDto {

    private Integer totalNumber;
    private Integer activeNumber;

}
