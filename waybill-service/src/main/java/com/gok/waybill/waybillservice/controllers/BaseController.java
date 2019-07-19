package com.gok.waybill.waybillservice.controllers;


import com.gok.waybill.waybillservice.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;

@RestController
public abstract class BaseController {

    private List<Model> list;

    @GetMapping("/")
    public List<Model> listAll() {
        return list;
    }

    @PostMapping("/")
    public abstract Model create(@RequestBody Model categoryMachine);

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        final Predicate<Model> predicate = predicateDeleteById(id);
        boolean notFound = list.stream().allMatch(predicate);
        if (notFound) {
            //throw new RuntimeException("NOT FOUND CATEGORY FOR DELETE");
            return false;
        }


        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return true;
    }
}
