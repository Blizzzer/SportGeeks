package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.SportEventDTO;
import com.codeknab.sportgeeks.dtos.SportEventListElementDTO;
import com.codeknab.sportgeeks.dtos.SportEventPostDTO;
import com.codeknab.sportgeeks.enums.Gender;
import com.codeknab.sportgeeks.enums.SportType;
import com.codeknab.sportgeeks.mapper.SportEventMapper;
import com.codeknab.sportgeeks.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<SportEventListElementDTO> getFilteredSportEvent(
            @RequestParam("maxLat") Double maxLatitude,
            @RequestParam("minLat") Double minLatitude,
            @RequestParam("maxLong") Double maxLongitude,
            @RequestParam("minLong") Double minLongitude,
            @RequestParam("sport") SportType sportType,
            @RequestParam("gender") Gender gender
    ) {
        return mapper.toSportEventListElementDTOs(
                service.getFilteredSportEvents(
                        maxLatitude, minLatitude,
                        maxLongitude, minLongitude,
                        sportType, gender
                ));
    }

    @PostMapping
    public SportEventPostDTO postSportEvent(@RequestBody SportEventPostDTO sportEventPostDTO) {
        return mapper.toSportEventPostDTO(service.saveSportEvent(mapper.toSportEvent(sportEventPostDTO)));
    }
}
