package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.CategoryMachine;
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
