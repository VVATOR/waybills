package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers/")
public class DriverController extends AbstractRestController<Driver> {

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        super(driverRepository, Driver.class);
    }
}
