package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/waybills/")
public class WaybillRestController extends AbstractRestController<Waybill> {

    @Autowired
    public WaybillRestController(WaybillRepository waybillRepository) {
        super(waybillRepository, Waybill.class);
    }
}
