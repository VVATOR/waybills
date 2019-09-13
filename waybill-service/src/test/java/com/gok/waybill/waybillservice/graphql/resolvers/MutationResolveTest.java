package com.gok.waybill.waybillservice.graphql.resolvers;

import com.gok.waybill.waybillservice.constants.UserRole;
import com.gok.waybill.waybillservice.data.dto.CategoryMachineDto;
import com.gok.waybill.waybillservice.data.dto.DriverDto;
import com.gok.waybill.waybillservice.data.dto.MachineDto;
import com.gok.waybill.waybillservice.data.dto.user.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("GraphQL Mutation")
public class MutationResolveTest {

    @Autowired
    private MutationResolver mutationResolver;


    public MutationResolveTest() {
    }

    @Test
    @DisplayName("Create User")
    public void createUser_returnUser() {
        final UserDto dto = UserDto.builder()
                .login("user login")
                .password("user password")
                .role(UserRole.ADMIN)
                .build();
        final UserDto actual = mutationResolver.createUser(dto);
        assertNotNull("Id will be not null", actual.getId());
        assertEquals("Not equals field login", dto.getLogin(), actual.getLogin());
    }

    @Test
    @DisplayName("Create Category of machine")
    public void createCategoryMachine_returnCategoryMachine() {
        final MachineDto machine1 = MachineDto.builder()
                .name("audi")
                .garageNumber("machine1: garage number")
                .registrationNumber("machine1 registration number")
                .build();
        machine1.setId(1);
        final MachineDto machine2 = MachineDto.builder()
                .name("BMW")
                .garageNumber("machine2: garage number")
                .registrationNumber("machine2 registration number")
                .build();
        machine1.setId(2);
        final List<MachineDto> machineDtoList = new ArrayList<>();
        machineDtoList.add(machine1);
        machineDtoList.add(machine2);

        final CategoryMachineDto dto = CategoryMachineDto.builder()
                .name("name of machine category")
                .machines(machineDtoList)
                .build();

        final CategoryMachineDto actual = mutationResolver.createCategoryMachine(dto);
        assertNotNull("Id will be not null", actual.getId());
        assertEquals("Not equals field name", dto.getName(), actual.getName());
        assertEquals("not equals count machines", dto.getMachines().size(), actual.getMachines().size());
    }


    @Test
    @DisplayName("Create Machine")
    public void createMachine_returnMachine() {

        final CategoryMachineDto category = CategoryMachineDto.builder()
                .name("category")
                .build();
        category.setId(1);
        final MachineDto dto = MachineDto.builder()
                .name("machine name")
                .garageNumber("machine garage number")
                .registrationNumber("machine registration number")
                .categoryMachine(category)
                .build();

        final MachineDto actual = mutationResolver.createMachine(dto);
        assertNotNull("Id will be not null", actual.getId());
        assertEquals("Not equals field name", dto.getName(), actual.getName());
        assertEquals("Not equals field category.id", dto.getCategoryMachine().getId(), actual.getCategoryMachine().getId());
    }


    @Test
    @DisplayName("Create Driver")
    public void createDriver_returnDriver() {

        final DriverDto dto = DriverDto.builder()
                .name("driver name")
                .personalNumber("driver personal number")
                .build();

        final DriverDto actual = mutationResolver.createDriver(dto);
        assertNotNull("Id will be not null", actual.getId());
        assertEquals("Not equals field name", dto.getName(), actual.getName());
    }


}