package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories/")
public class CategoryController extends AbstractRestController<CategoryMachine> {

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        super(categoryRepository, CategoryMachine.class);
    }
}
