package com.gok.waybill.waybillservice.controllers;


import com.gok.waybill.waybillservice.model.Machine;
import com.gok.waybill.waybillservice.model.Model;
import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;

@RestController()
@RequestMapping("/machines/")
public class MachineController {

    private static List<Machine> list =  CommonFakeDatabase.machines;

    @GetMapping("/")
    public List<Machine> machines() {
        return list;
    }

    @PostMapping("/")
    public Machine addMachine(@RequestBody Machine machine) {
        machine.setId(new Random().nextInt());
        list.add(machine);
        return machine;
    }

    @DeleteMapping("/{id}")
    public boolean deleteMachine(@PathVariable("id") Integer id) {
        final Predicate<Model> predicate = predicateDeleteById(id);
        boolean notFound = list.stream().allMatch(predicate);
        if(notFound){
            //throw new RuntimeException("NOT FOUND MACHINE FOR DELETE");
            return false;
        }


        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return true;
    }


}
