package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.exceptions.ResourceNotFoundException;
import com.codeknab.sportgeeks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getSingleUser(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
