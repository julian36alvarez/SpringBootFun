package com.fundamentosspf.fundamentos.caseuse;

import com.fundamentosspf.fundamentos.entity.User;
import com.fundamentosspf.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
