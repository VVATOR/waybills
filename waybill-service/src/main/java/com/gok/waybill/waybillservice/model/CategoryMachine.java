package com.gok.waybill.waybillservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CategoryMachine extends Model {
    private String name;

    public CategoryMachine() {
    }
}

