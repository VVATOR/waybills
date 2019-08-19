package com.gok.waybill.waybillservice.data.repositories;

import com.gok.waybill.waybillservice.data.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> { //todo: Long
}
