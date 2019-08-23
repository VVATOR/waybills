package com.gok.waybill.waybillservice.graphql.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.repositories.*;
import com.gok.waybill.waybillservice.reports.DBFileRepository;
import com.gok.waybill.waybillservice.reports.DbFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class QueryResolver implements GraphQLQueryResolver {

    private WaybillRepository waybillRepository;
    private CategoryRepository categoryRepository;
    private MachineRepository machineRepository;
    private DriverRepository driverRepository;
    private UserRepository userRepository;

    private DBFileRepository dbFileRepository;

    @Autowired
    public QueryResolver(
            WaybillRepository waybillRepository,
            CategoryRepository categoryRepository,
            MachineRepository machineRepository,
            DriverRepository driverRepository,
            UserRepository userRepository,
            DBFileRepository dbFileRepository
    ) {
        log.info("@Bean QueryResolver Initialisation");
        this.waybillRepository = waybillRepository;
        this.categoryRepository = categoryRepository;
        this.machineRepository = machineRepository;
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
        this.dbFileRepository = dbFileRepository;
    }

    public List<Waybill> allWaybills() {
        return waybillRepository.findAll();
    }

    public List<CategoryMachine> allCategoryMachines() {
        return categoryRepository.findAll();
    }

    public List<Driver> allDrivers() {
        return driverRepository.findAll();
    }

    public List<Machine> allMachines() {
        return machineRepository.findAll();
    }

    public List<DbFile> allDbFiles() {
        return dbFileRepository.findAll();
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }


    public long countWaybills() {
        return waybillRepository.count();
    }
}