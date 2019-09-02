package com.gok.waybill.waybillservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CategoryMachineDto extends Dto {

    private String name;

    private Collection<MachineDto> machines;

    public CategoryMachineDto() {
    }
}

