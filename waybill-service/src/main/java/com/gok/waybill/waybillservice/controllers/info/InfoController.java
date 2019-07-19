package com.gok.waybill.waybillservice.controllers.info;


import com.gok.waybill.waybillservice.dto.InfoWaybillDto;
import com.gok.waybill.waybillservice.model.Waybill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.waybills;

@RestController()
@RequestMapping("/waybills/")
public class InfoController {

    private static List<Waybill> list = waybills;

    @GetMapping("/info")
    public InfoWaybillDto waybillsInfo() {
        // Todo change active count algorithm
        return new InfoWaybillDto(waybills.size(),waybills.size());
    }


}
