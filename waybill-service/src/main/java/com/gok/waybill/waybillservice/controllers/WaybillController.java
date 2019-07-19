package com.gok.waybill.waybillservice.controllers;


import com.gok.waybill.waybillservice.model.Model;
import com.gok.waybill.waybillservice.model.Waybill;
import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;

@RestController()
@RequestMapping("/waybills/")
public class WaybillController {

    private static List<Waybill> list =   CommonFakeDatabase.waybills;

    @GetMapping("/")
    public List<Waybill> waybills() {
        return list;
    }

    @PostMapping("/")
    public Waybill addWaybill(@RequestBody Waybill waybill) {
        waybill.setId(new Random().nextInt());
        list.add(waybill);
        return waybill;
    }

    @DeleteMapping("/{id}")
    public boolean deleteWaybill(@PathVariable("id") Integer id) {
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
