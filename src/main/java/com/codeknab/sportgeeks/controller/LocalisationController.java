package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.dtos.LocalisationDTO;
import com.codeknab.sportgeeks.enums.SportType;
import com.codeknab.sportgeeks.mapper.LocalisationMapper;
import com.codeknab.sportgeeks.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localisation")
public class LocalisationController {
    @Autowired
    private LocalisationMapper mapper;

    @Autowired
    private LocalisationService service;

    @GetMapping
    public List<LocalisationDTO> getFilteredLocalisations(
            @RequestParam("maxLat") Double maxLatitude,
            @RequestParam("minLat") Double minLatitude,
            @RequestParam("maxLong") Double maxLongitude,
            @RequestParam("minLong") Double minLongitude,
            @RequestParam("sport") SportType sportType
    ) {
        return mapper.toLocalisationDTOs(service.getFilteredLocalisations(
                maxLatitude,
                minLatitude,
                maxLongitude,
                minLongitude,
                sportType
        ));
    }
}
