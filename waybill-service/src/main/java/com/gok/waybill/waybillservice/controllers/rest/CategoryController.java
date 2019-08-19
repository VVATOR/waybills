package com.gok.waybill.waybillservice.controllers.rest;


import com.gok.waybill.waybillservice.model.CategoryMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase.categoryMachine;

@RestController
@RequestMapping("/categories/")
public class CategoryController extends AbstractRestController<CategoryMachine> {

    public CategoryController() {
        super(categoryMachine);
    }
}
