package com.gok.waybill.waybillservice.controllers.rest;


import com.gok.waybill.waybillservice.model.Machine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.machines;

@RestController
@RequestMapping("/machines/")
public class MachineController extends AbstractRestController<Machine> {

    public MachineController() {
        super(machines);
    }

}
