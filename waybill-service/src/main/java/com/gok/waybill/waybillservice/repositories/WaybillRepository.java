package com.gok.waybill.waybillservice.repositories;

import com.gok.waybill.waybillservice.model.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillRepository extends JpaRepository<Waybill, Integer> { //todo: Long
}
