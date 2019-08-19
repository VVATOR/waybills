package com.gok.waybill.waybillservice.controllers.rest;


import com.gok.waybill.waybillservice.model.Driver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.drivers;

@RestController
@RequestMapping("/drivers/")
public class DriverController extends AbstractRestController<Driver> {


    public DriverController() {
        super(drivers);
    }
}
