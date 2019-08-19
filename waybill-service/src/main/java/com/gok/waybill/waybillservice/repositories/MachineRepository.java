package com.gok.waybill.waybillservice.repositories;

import com.gok.waybill.waybillservice.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Integer> { //todo: Long
}
