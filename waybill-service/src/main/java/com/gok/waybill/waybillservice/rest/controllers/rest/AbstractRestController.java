package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public abstract class AbstractRestController<T extends Model> {


    private Class<T> type;

    @Autowired
    private ModelMapper modelMapper;


    private JpaRepository<T, Integer> repository;

    public AbstractRestController(JpaRepository<T, Integer> repository, Class<T> type) {
        this.repository = repository;
        this.type = type;
    }

    @GetMapping("/")
    public List<T> getAll() {
        return repository.findAll().stream()
                .map(m -> modelMapper.map(m, type))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable("id") Integer id) {
        return repository.findAll().stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    @PostMapping("/")
    public T create(@RequestBody T model) {
        model.setId(new Random().nextInt());
        return repository.save(model);
    }

    @PutMapping("/{id}")
    public T updateOrAdd(@PathVariable("id") Integer id, @RequestBody T model) {
        model.setId(new Random().nextInt());
        return repository.save(model);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
}
