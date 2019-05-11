package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.UserDTO;
import com.codeknab.sportgeeks.mapper.UserMapper;
import com.codeknab.sportgeeks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

    @GetMapping("/{id}")
    public UserDTO getSingleUser(@PathVariable Long id) {
        return mapper.toUserDTO(service.getSingleUser(id));
    }

    @GetMapping("")
    public UserDTO getSingleUserByUID(@RequestParam("uid") String uid) {
        return mapper.toUserDTO(service.getSingleUserByUID(uid));
    }

    @PostMapping
    public UserDTO postUser(@RequestBody UserDTO userDTO) {
        return mapper.toUserDTO(
                service.postUser(
                        mapper.toUser(userDTO)
                )
        );
    }
}
