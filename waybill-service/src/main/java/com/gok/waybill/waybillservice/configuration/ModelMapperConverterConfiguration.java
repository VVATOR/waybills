package com.gok.waybill.waybillservice.configuration;

import com.gok.waybill.waybillservice.data.dto.*;
import com.gok.waybill.waybillservice.data.dto.waybill.ResultDto;
import com.gok.waybill.waybillservice.data.dto.waybill.TaskDto;
import com.gok.waybill.waybillservice.data.dto.waybill.TsmDto;
import com.gok.waybill.waybillservice.data.dto.waybill.WorkDriverAndMachineDto;
import com.gok.waybill.waybillservice.data.model.*;
import com.gok.waybill.waybillservice.data.model.waybill.Result;
import com.gok.waybill.waybillservice.data.model.waybill.TSM;
import com.gok.waybill.waybillservice.data.model.waybill.Task;
import com.gok.waybill.waybillservice.data.model.waybill.WorkDriverAndMachine;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.stream.Collectors;


@Configuration
public class ModelMapperConverterConfiguration {

    private final ModelMapper modelMapper;

    @Autowired
    ModelMapperConverterConfiguration(ModelMapper modelMapper) {
        this.modelMapper = new ModelMapper();
        modelMapper.addConverter(converterWaybillDtoToModel);
        modelMapper.addConverter(converterWaybillModelToDto);
        modelMapper.addConverter(converterCategoryMachineDtoToModel);
        modelMapper.addConverter(converterCategoryMachineModelToDto);
        modelMapper.addConverter(converterDriverDtoToModel);
        modelMapper.addConverter(converterDriverModelToDto);
        modelMapper.addConverter(converterMachineDtoToModel);
        modelMapper.addConverter(converterMachineModelToDto);
    }


    protected void fieldDtoToModel(Dto dto, Model model) {
        model.setId(dto.getId());
        model.setDeleted(dto.isDeleted());
    }

    protected void fieldModelToDto(Model model, Dto dto) {
        dto.setId(model.getId());
        dto.setDeleted(model.isDeleted());
    }

    protected Converter<WaybillDto, Waybill> converterWaybillDtoToModel = new Converter<WaybillDto, Waybill>() {
        @Override
        public Waybill convert(MappingContext<WaybillDto, Waybill> context) {
            WaybillDto source = context.getSource();
            Waybill result = context.getDestination();
            fieldDtoToModel(source, result);
            result.setStatus(source.getStatus());
            result.setNumber(source.getNumber());
            result.setDate(source.getDate());
            result.setMachine(modelMapper.map(source.getMachine(), Machine.class));
            result.setDrivers(source.getDrivers().stream()
                    .map(m -> modelMapper.map(m, Driver.class))
                    .collect(Collectors.toList()));
            result.setTask(modelMapper.map(source.getTask(), Task.class));
            result.setWorkDriverAndMachine(modelMapper.map(source.getWorkDriverAndMachine(), WorkDriverAndMachine.class));
            result.setResult(modelMapper.map(source.getResult(), Result.class));
            result.setTsm(modelMapper.map(source.getTsm(), TSM.class));
            return result;
        }
    };
    protected Converter<Waybill, WaybillDto> converterWaybillModelToDto = new Converter<Waybill, WaybillDto>() {
        @Override
        public WaybillDto convert(MappingContext<Waybill, WaybillDto> context) {
            Waybill source = context.getSource();
            WaybillDto result = context.getDestination();
            fieldModelToDto(source, result);
            result.setStatus(source.getStatus());
            result.setNumber(source.getNumber());
            result.setDate(source.getDate());
            result.setMachine(modelMapper.map(source.getMachine(), MachineDto.class));
            result.setDrivers(source.getDrivers().stream()
                    .map(m -> modelMapper.map(m, DriverDto.class))
                    .collect(Collectors.toList()));
            result.setTask(modelMapper.map(source.getTask(), TaskDto.class));
            result.setWorkDriverAndMachine(modelMapper.map(source.getWorkDriverAndMachine(), WorkDriverAndMachineDto.class));
            result.setResult(modelMapper.map(source.getResult(), ResultDto.class));
            result.setTsm(modelMapper.map(source.getTsm(), TsmDto.class));
            return result;
        }
    };


    protected final Converter<CategoryMachineDto, CategoryMachine> converterCategoryMachineDtoToModel = new Converter<CategoryMachineDto, CategoryMachine>() {
        @Override
        public CategoryMachine convert(MappingContext<CategoryMachineDto, CategoryMachine> context) {
            CategoryMachineDto source = context.getSource();
            CategoryMachine result = context.getDestination();
            fieldDtoToModel(source, result);
            result.setName(source.getName());
            result.setMachines(
                    source.getMachines()
                            .stream()
                            .map(m -> modelMapper.map(m, Machine.class))
                            .collect(Collectors.toList())
            );
            return result;
        }
    };
    protected final Converter<CategoryMachine, CategoryMachineDto> converterCategoryMachineModelToDto = new Converter<CategoryMachine, CategoryMachineDto>() {
        @Override
        public CategoryMachineDto convert(MappingContext<CategoryMachine, CategoryMachineDto> context) {
            CategoryMachine source = context.getSource();
            CategoryMachineDto result = context.getDestination();
            fieldModelToDto(source, result);
            result.setName(source.getName());
            Collection<Machine> machines = source.getMachines();
            result.setMachines(
                    machines
                            .stream()
                            .map(m -> modelMapper.map(m, MachineDto.class))
                            .collect(Collectors.toList())
            );
            return result;
        }

    };

    protected final Converter<DriverDto, Driver> converterDriverDtoToModel = new Converter<DriverDto, Driver>() {
        @Override
        public Driver convert(MappingContext<DriverDto, Driver> context) {
            DriverDto source = context.getSource();
            Driver result = context.getDestination();
            fieldDtoToModel(source, result);
            result.setName(source.getName());
            result.setPersonalNumber(source.getPersonalNumber());
            return result;
        }
    };
    protected final Converter<Driver, DriverDto> converterDriverModelToDto = new Converter<Driver, DriverDto>() {
        @Override
        public DriverDto convert(MappingContext<Driver, DriverDto> context) {
            Driver source = context.getSource();
            DriverDto result = context.getDestination();
            fieldModelToDto(source, result);
            result.setName(source.getName());
            result.setPersonalNumber(source.getPersonalNumber());
            return result;
        }

    };

    protected final Converter<MachineDto, Machine> converterMachineDtoToModel = new Converter<MachineDto, Machine>() {
        @Override
        public Machine convert(MappingContext<MachineDto, Machine> context) {
            MachineDto source = context.getSource();
            Machine result = context.getDestination();
            fieldDtoToModel(source, result);
            result.setName(source.getName());
            result.setRegistrationNumber(source.getRegistrationNumber());
            result.setGarageNumber(source.getGarageNumber());
            return result;
        }
    };
    protected final Converter<Machine, MachineDto> converterMachineModelToDto = new Converter<Machine, MachineDto>() {
        @Override
        public MachineDto convert(MappingContext<Machine, MachineDto> context) {
            Machine source = context.getSource();
            MachineDto result = context.getDestination();
            fieldModelToDto(source, result);
            result.setName(source.getName());
            result.setRegistrationNumber(source.getRegistrationNumber());
            result.setGarageNumber(source.getGarageNumber());
            return result;
        }
    };

}
