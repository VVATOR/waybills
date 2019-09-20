package com.gok.waybill.waybillservice.data.repositories;

import com.gok.waybill.waybillservice.constants.UserRole;
import com.gok.waybill.waybillservice.data.model.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@DataJpaTest
@DisplayName("Integration: UserRepository")
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Find user by login and return User")
    public void findByLogin_thenReturnUser() {
        final User alex = User.builder()
                .login("Lelek")
                .password("Bolek")
                .role(UserRole.ADMIN)
                .build();
        final User savedUser = userRepository.save(alex);
        final User found = userRepository.findByLogin(alex.getLogin());
        assertEquals(savedUser.getLogin(), found.getLogin());
    }

    @Test
    @DisplayName("Not found user by login")
    public void findByLogain_notFound() {
        final String EXPECTED = "NOT EXIST USER LOGIN";
        final User found = userRepository.findByLogin(EXPECTED);
        assertNull(found);
    }
}
