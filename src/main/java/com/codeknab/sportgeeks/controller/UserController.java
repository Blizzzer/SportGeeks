package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public UserDTO getSingleUser(@PathVariable Long userId) {
        return new UserDTO();
    }
}
