package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository repository;

    public Participation addParticipation(Participation participation) {
        return repository.save(participation);
    }
}
