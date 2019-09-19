package com.gok.waybill.waybillservice.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Dto implements Serializable {

    private Integer id;

    private boolean isDeleted = false;

    public Dto() {
        super();
    }
}

