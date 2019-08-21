package com.gok.waybill.waybillservice.data.repositories;

import com.gok.waybill.waybillservice.data.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> { //todo: Long
}
