package com.gok.waybill.waybillservice.controllers;


import com.gok.waybill.waybillservice.model.CategoryMachine;
import com.gok.waybill.waybillservice.model.Model;
import com.gok.waybill.waybillservice.utils.fakedata.CommonFakeDatabase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gok.waybill.waybillservice.utils.CommonFunction.predicateDeleteById;

@RestController
@RequestMapping("/categories/")
public class CategoryController {

    private static List<CategoryMachine> list = CommonFakeDatabase.categoryMachine;

    @GetMapping("/")
    public List<CategoryMachine> categories() {
        return list;
    }

    @PostMapping("/")
    public CategoryMachine addCategory(@RequestBody CategoryMachine categoryMachine) {
        categoryMachine.setId(new Random().nextInt());
        list.add(categoryMachine);
        return categoryMachine;
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id") Integer id) {
        final Predicate<Model> predicate = predicateDeleteById(id);
        boolean notFound = list.stream().allMatch(predicate);
        if(notFound){
            //throw new RuntimeException("NOT FOUND CATEGORY FOR DELETE");
            return false;
        }


        list = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return true;
    }


}
