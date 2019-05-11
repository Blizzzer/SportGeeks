package com.codeknab.sportgeeks.controller;

import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.dtos.ParticipationDTO;
import com.codeknab.sportgeeks.dtos.ParticipationPostDTO;
import com.codeknab.sportgeeks.mapper.ParticipationMapper;
import com.codeknab.sportgeeks.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participation")
public class ParticipationController {
    @Autowired
    private ParticipationService service;

    @Autowired
    private ParticipationMapper mapper;

    @PostMapping("/{eventId}")
    public ParticipationPostDTO addParticipationToSportEvent(@RequestBody ParticipationPostDTO participation,
                                                         @PathVariable Long eventId) {
        Participation participationToAdd = mapper.toParticipation(participation);
        participationToAdd.setSportEventId(eventId);
        return mapper.toParticipationPostDTO(service.addParticipation(participationToAdd));
    }
}
