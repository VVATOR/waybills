package com.gok.waybill.waybillservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DriverDto extends Dto {
    private String name;

    private String personalNumber;

    public DriverDto() {
    }
}
