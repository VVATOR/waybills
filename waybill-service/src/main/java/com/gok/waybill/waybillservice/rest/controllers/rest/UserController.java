package com.gok.waybill.waybillservice.rest.controllers.rest;


import com.gok.waybill.waybillservice.data.model.user.User;
import com.gok.waybill.waybillservice.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController extends AbstractRestController<User> {

    @Autowired
    public UserController(UserRepository userRepository) {
        super(userRepository, User.class);
    }

}
