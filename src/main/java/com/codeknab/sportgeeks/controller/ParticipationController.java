package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.dtos.ParticipationPostDTO;
import com.codeknab.sportgeeks.mapper.ParticipationMapper;
import com.codeknab.sportgeeks.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/participation")
public class ParticipationController {
    @Autowired
    private ParticipationService service;

    @Autowired
    private ParticipationMapper mapper;

    @PostMapping("/{eventId}")
    public ParticipationPostDTO addParticipationToSportEvent(@Valid @RequestBody ParticipationPostDTO participation,
                                                         @PathVariable Long eventId) {
        Participation participationToAdd = mapper.toParticipation(participation);
        participationToAdd.setSportEventId(eventId);
        return mapper.toParticipationPostDTO(service.addParticipation(participationToAdd));
    }



    @DeleteMapping("/{participationId}")
    public void deleteParticipation(@PathVariable Long participationId) {
        service.deleteParticipation(participationId);
    }
}
