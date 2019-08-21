package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.Waybill;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.waybills;

@RestController
@RequestMapping("/waybills/")
public class WaybillRestController extends AbstractRestController<Waybill> {
    public WaybillRestController() {
        super(waybills);
    }
}
