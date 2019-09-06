package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machines/")
public class MachineController extends AbstractRestController<Machine> {

    @Autowired
    public MachineController(MachineRepository machineRepository) {
        super(machineRepository, Machine.class);
    }

}
