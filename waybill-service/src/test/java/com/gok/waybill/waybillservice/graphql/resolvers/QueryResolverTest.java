package com.gok.waybill.waybillservice.graphql.resolvers;

import com.gok.waybill.waybillservice.constants.Status;
import com.gok.waybill.waybillservice.constants.UserRole;
import com.gok.waybill.waybillservice.data.dto.DriverDto;
import com.gok.waybill.waybillservice.data.dto.WaybillDto;
import com.gok.waybill.waybillservice.data.dto.user.UserDto;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Waybill;
import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.repositories.DriverRepository;
import com.gok.waybill.waybillservice.data.repositories.UserRepository;
import com.gok.waybill.waybillservice.data.repositories.WaybillRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("GraphQL QueryResolver")
class QueryResolverTest {

    @Autowired
    private QueryResolver queryResolver;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public DriverRepository driverRepository;

    @Autowired
    public WaybillRepository waybillsRepository;

    public QueryResolverTest() {
    }

    @Test
    void allUsers() {

        userRepository.save(User.builder()
                .login("login")
                .password("password")
                .role(UserRole.ADMIN)
                .build());

        List<UserDto> userDtos = queryResolver.allUsers();
        assertTrue("Not found users in DB", userDtos.size() > 0);
    }

    @Test
    void allDrivers() {
        driverRepository.save(Driver.builder()
                .name("name")
                .personalNumber("personal number")
                .build());

        List<DriverDto> driver = queryResolver.allDrivers();
        assertTrue("Not found driver in DB", driver.size() > 0);
    }

    @Test
    void countWaybills() {
        waybillsRepository.save(Waybill.builder()
                .status(Status.ACTIVE)
                .date(LocalDate.now())
                .number("number")
                .build());

        List<WaybillDto> waybills = queryResolver.allWaybills();
        assertTrue("Not found waybills in DB", waybills.size() > 0);
    }
}