package com.gok.waybill.waybillservice.utils.fakedata;

import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;
import com.gok.waybill.waybillservice.data.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public final class FillCommonFakeDatabase {

    @Autowired
    public FillCommonFakeDatabase(
            UserRepository userRepository,
            WaybillRepository waybillRepository,
            MachineRepository machineRepository,
            DriverRepository driverRepository,
            CategoryRepository categoryRepository
    ) {
        log.info("Fill Fake Database");


        // sequrity
        log.info("==> User");
        userRepository.saveAll(CommonFakeDatabase.users);

        // additional
        log.info("==> TsmDto");
        List<TSM> tsm = CommonFakeDatabase.tsm;

        log.info("==> TaskDto");
        List<Task> tasks = CommonFakeDatabase.tasks;

        log.info("==> ResultDto");
        List<Result> results = CommonFakeDatabase.results;

        log.info("==> Work");
        List<WorkDriverAndMachine> workDriverAndMachines = CommonFakeDatabase.workDriverAndMachines;


        /// base
        log.info("==> Driver");
        driverRepository.saveAll(CommonFakeDatabase.drivers);

        log.info("==> CategoryMachine");
        categoryRepository.saveAll(CommonFakeDatabase.categoryMachine);

        log.info("==> Machine");
        machineRepository.saveAll(CommonFakeDatabase.machines);

        log.info("==> WaybillDto");
        waybillRepository.saveAll(CommonFakeDatabase.waybills);
    }
}

