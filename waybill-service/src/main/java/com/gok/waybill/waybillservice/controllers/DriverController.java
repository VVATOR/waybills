package com.gok.waybill.waybillservice.controllers;


import com.gok.waybill.waybillservice.model.Driver;
import com.gok.waybill.waybillservice.model.Model;
import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;

@RestController()
@RequestMapping("/drivers/")
public class DriverController {


    private static List<Driver> list = CommonFakeDatabase.drivers;

    @GetMapping("/")
    public List<Driver> drivers() {
        return list;
    }

    @PostMapping("/")
    public Driver addDriver(@RequestBody Driver machine) {
        machine.setId(new Random().nextInt());
        list.add(machine);
        return machine;
    }

    @DeleteMapping("/{id}")
    public boolean deleteDriver(@PathVariable("id") Integer id) {
        final Predicate<Model> predicate = predicateDeleteById(id);
        boolean notFound = list.stream().allMatch(predicate);
        if(notFound){
            //throw new RuntimeException("NOT FOUND DRIVER FOR DELETE");
            return false;
        }


        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return true;
    }


}
