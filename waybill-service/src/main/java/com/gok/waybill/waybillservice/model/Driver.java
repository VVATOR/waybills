package com.gok.waybill.waybillservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Driver extends Model {
    private String name;
    private String personalNumber;

    public Driver() {
    }
}
