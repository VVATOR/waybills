package com.gok.waybill.waybillservice.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gok.waybill.waybillservice.data.dto.CategoryMachineDto;
import com.gok.waybill.waybillservice.data.dto.DriverDto;
import com.gok.waybill.waybillservice.data.dto.MachineDto;
import com.gok.waybill.waybillservice.data.dto.WaybillDto;
import com.gok.waybill.waybillservice.data.dto.user.UserDto;
import com.gok.waybill.waybillservice.data.model.CategoryMachine;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Machine;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.repositories.*;
import com.gok.waybill.waybillservice.reports.DBFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MutationResolver implements GraphQLMutationResolver {

    private ModelMapper modelMapper;

    private WaybillRepository waybillRepository;
    private CategoryRepository categoryRepository;
    private MachineRepository machineRepository;
    private DriverRepository driverRepository;
    private UserRepository userRepository;

    private DBFileRepository dbFileRepository;

    public MutationResolver() {
        super();
    }

    @Autowired
    public MutationResolver(
            ModelMapper modelMapper,
            WaybillRepository waybillRepository,
            CategoryRepository categoryRepository,
            MachineRepository machineRepository,
            DriverRepository driverRepository,
            UserRepository userRepository,
            DBFileRepository dbFileRepository) {
        log.info("@Bean MutationResolver Initialisation");
        this.modelMapper = modelMapper;
        this.waybillRepository = waybillRepository;
        this.categoryRepository = categoryRepository;
        this.machineRepository = machineRepository;
        this.driverRepository = driverRepository;
        this.userRepository = userRepository;
        this.dbFileRepository = dbFileRepository;
    }

    public UserDto createUser(UserDto userDto) {
        return modelMapper.map(
                userRepository.save(
                        modelMapper.map(userDto, User.class)
                ), UserDto.class);
    }

    public CategoryMachineDto createCategoryMachine(CategoryMachineDto categoryMachine) {
        return modelMapper.map(
                categoryRepository.save(
                        modelMapper.map(categoryMachine, CategoryMachine.class)
                ), CategoryMachineDto.class);
    }

    public MachineDto createMachine(MachineDto machineDto) {
        return modelMapper.map(
                machineRepository.save(
                        modelMapper.map(machineDto, Machine.class)
                ), MachineDto.class);
    }

    public DriverDto createDriver(DriverDto driver) {
        return modelMapper.map(
                driverRepository.save(
                        modelMapper.map(driver, Driver.class)
                ), DriverDto.class);
    }

    public WaybillDto createWaybillDto(WaybillDto waybillDto) {
        return modelMapper.map(
                waybillRepository.save(
                        modelMapper.map(waybillDto, Waybill.class)
                ), WaybillDto.class);
    }


}
