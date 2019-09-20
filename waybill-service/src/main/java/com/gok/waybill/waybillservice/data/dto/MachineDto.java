package com.gok.waybill.waybillservice.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MachineDto extends Dto {
    private String name;

    private CategoryMachineDto categoryMachine;

    private String registrationNumber;

    private String garageNumber;

    public MachineDto() {
        super();
    }
}
