package com.gok.waybill.waybillservice.data.repositories;

import com.gok.waybill.waybillservice.data.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { //todo: Long

    User findByLogin(String login);
}
