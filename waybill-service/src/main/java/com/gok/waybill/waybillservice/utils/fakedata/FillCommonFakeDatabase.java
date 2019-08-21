package com.gok.waybill.waybillservice.utils.fakedata;

import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;
import com.gok.waybill.waybillservice.data.repositories.CategoryRepository;
import com.gok.waybill.waybillservice.data.repositories.DriverRepository;
import com.gok.waybill.waybillservice.data.repositories.MachineRepository;
import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.gok.waybill.waybillservice.utils.fakedata.RandomGenerator.*;

@Component
@Slf4j
public final class FillCommonFakeDatabase {


    @Autowired
    public FillCommonFakeDatabase(
            WaybillRepository waybillRepository,
            MachineRepository machineRepository,
            DriverRepository driverRepository,
            CategoryRepository categoryRepository

    ) {
        log.info("Fill Fake Database");
        List<TSM> tsm = randomTsmList();

        log.info("==> Task");
        List<Task> tasks = randomTasksList();

        List<Result> results = randomResultList();

        List<WorkDriverAndMachine> workDriverAndMachines = randomWorkDriverAndMachinesList();


        /// base

        log.info("==> Driver");
        List<Driver> drivers = randomDriverList();
        driverRepository.saveAll(drivers);


        log.info("==> CategoryMachine");
        List<CategoryMachine> categoryMachine = randomCategoryList();
        categoryRepository.saveAll(categoryMachine);

        log.info("==> Machine");
        List<Machine> machines = randomMachineList();
        machineRepository.saveAll(machines);


        log.info("==> Waybill");
        List<Waybill> waybills = randomWaybillList();
        waybillRepository.saveAll(waybills);
    }
}

