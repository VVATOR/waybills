package com.gok.waybill.waybillservice.utils;

import com.gok.waybill.waybillservice.model.Model;

import java.util.function.Predicate;

public final class CommonFunction {
    private CommonFunction() {
    }

    public static Predicate<Model> predicateDeleteById(Integer id) {
        return model -> !model.getId().equals(id);
    }
}
