package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.SportEventDTO;
import com.codeknab.sportgeeks.dtos.SportEventPostDTO;
import com.codeknab.sportgeeks.mapper.SportEventMapper;
import com.codeknab.sportgeeks.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class SportEventController {

    @Autowired
    private SportEventService service;

    @Autowired
    private SportEventMapper mapper;

    @GetMapping("/{id}")
    public SportEventDTO getSingleSportEvent(@PathVariable Long id) {
        return mapper.toSportEventDTO(service.getSingleSportEvent(id));
    }

    @PostMapping
    public SportEventPostDTO postSportEvent(@RequestBody SportEventPostDTO sportEventPostDTO) {
        return mapper.toSportEventPostDTO(service.saveSportEvent(mapper.toSportEvent(sportEventPostDTO)));
    }
}
