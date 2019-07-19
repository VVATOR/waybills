package com.gok.waybill.waybillservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Model {
    private Integer id;

    private boolean isDeleted = false;

    public Model() {
    }
}
