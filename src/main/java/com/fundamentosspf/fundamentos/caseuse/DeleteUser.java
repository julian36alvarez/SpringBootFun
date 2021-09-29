package com.fundamentosspf.fundamentos.caseuse;

import com.fundamentosspf.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id) {
         userService.delete(id);
    }
}
