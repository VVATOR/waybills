package com.gok.waybill.waybillservice.graphql.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gok.waybill.waybillservice.data.dto.CategoryMachineDto;
import com.gok.waybill.waybillservice.data.dto.DriverDto;
import com.gok.waybill.waybillservice.data.dto.MachineDto;
import com.gok.waybill.waybillservice.data.dto.WaybillDto;
import com.gok.waybill.waybillservice.data.dto.user.UserDto;
import com.gok.waybill.waybillservice.data.repositories.*;
import com.gok.waybill.waybillservice.reports.DBFileRepository;
import com.gok.waybill.waybillservice.reports.DatabaseFile;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class QueryResolver implements GraphQLQueryResolver {

    private ModelMapper modelMapper;

    private WaybillRepository waybillRepository;
    private CategoryRepository categoryRepository;
    private MachineRepository machineRepository;
    private DriverRepository driverRepository;
    private UserRepository userRepository;

    private DBFileRepository dbFileRepository;

    @Autowired
    public QueryResolver(
            ModelMapper modelMapper,
            WaybillRepository waybillRepository,
            CategoryRepository categoryRepository,
            MachineRepository machineRepository,
            DriverRepository driverRepository,
            UserRepository userRepository,
            DBFileRepository dbFileRepository
    ) {
        log.info("@Bean QueryResolver Initialisation");
        this.modelMapper = modelMapper;
        this.waybillRepository = waybillRepository;
        this.categoryRepository = categoryRepository;
        this.machineRepository = machineRepository;
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
        this.dbFileRepository = dbFileRepository;
    }

    public List<WaybillDto> allWaybills() {
        return waybillRepository.findAll().stream()
                .map(m -> modelMapper.map(m, WaybillDto.class))
                .collect(Collectors.toList());
    }

    public List<CategoryMachineDto> allCategoryMachines() {
        return categoryRepository.findAll().stream()
                .map(m -> modelMapper.map(m, CategoryMachineDto.class))
                .collect(Collectors.toList());
    }

    public List<DriverDto> allDrivers() {
        return driverRepository.findAll().stream()
                .map(m -> modelMapper.map(m, DriverDto.class))
                .collect(Collectors.toList());
    }

    public List<MachineDto> allMachines() {
        return machineRepository.findAll().stream()
                .map(m -> modelMapper.map(m, MachineDto.class))
                .collect(Collectors.toList());
    }

    public List<DatabaseFile> allDbFiles() {
        return dbFileRepository.findAll().stream()
                .map(m -> modelMapper.map(m, DatabaseFile.class))
                .collect(Collectors.toList());
    }

    public List<UserDto> allUsers() {
        return userRepository.findAll().stream()
                .map(m -> modelMapper.map(m, UserDto.class))
                .collect(Collectors.toList());
    }


    public long countWaybills() {
        return waybillRepository.count();
    }
}