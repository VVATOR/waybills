package com.gok.waybill.waybillservice.data.repositories;

import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryMachine, Integer> { //todo: Long


}
