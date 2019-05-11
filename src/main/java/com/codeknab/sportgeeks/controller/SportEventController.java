package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.SportEventDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class SportEventController {

    @GetMapping("/{id}")
    public SportEventDTO getSingleSportEvent(@PathVariable Long id) {
        
    }
}
