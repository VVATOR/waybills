package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;


public abstract class AbstractRestController<T extends Model> {

    private List<T> list;

    public AbstractRestController(List<T> list) {
        this.list = list;
    }

    @GetMapping("/")
    public List<T> getAll() {
        return list;
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable("id") Integer id) {
        return list.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @PostMapping("/")
    public T create(@RequestBody T model) {
        model.setId(new Random().nextInt());
        list.add(model);
        return model;
    }

    @PutMapping("/{id}")
    public T updateOrAdd(@PathVariable("id") Integer id, @RequestBody T model) {
        model.setId(new Random().nextInt());
        list.add(model);
        return model;
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        final Predicate<Model> predicate = predicateDeleteById(id);
        boolean notFound = list.stream().allMatch(predicate);
        if (notFound) {
            // throw new RuntimeException("NOT FOUND ELEMENT FOR DELETE");
            return false;
        }

        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return true;
    }
}
