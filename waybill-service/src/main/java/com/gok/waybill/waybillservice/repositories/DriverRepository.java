package com.gok.waybill.waybillservice.repositories;

import com.gok.waybill.waybillservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> { //todo: Long
}
