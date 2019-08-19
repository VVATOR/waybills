package com.gok.waybill.waybillservice.repositories;

import com.gok.waybill.waybillservice.model.CategoryMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryMachine, Integer> { //todo: Long


}
