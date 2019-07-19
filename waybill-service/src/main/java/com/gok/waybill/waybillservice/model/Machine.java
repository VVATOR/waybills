package com.gok.waybill.waybillservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Machine extends Model {
    private String name;
    private CategoryMachine categoryMachine;
    private String registrationNumber;
    private String garageNumber;

    public Machine() {
    }
}
