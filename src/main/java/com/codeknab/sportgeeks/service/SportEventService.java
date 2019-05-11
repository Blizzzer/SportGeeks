package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.enums.LocalisationPointType;
import com.codeknab.sportgeeks.exceptions.ResourceNotFoundException;
import com.codeknab.sportgeeks.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.codeknab.sportgeeks.enums.LocalisationPointType.CUSTOM;

@Service
public class SportEventService {
    @Autowired
    private SportEventRepository repository;

    public SportEvent getSingleSportEvent(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SportEvent", "id", id));
    }

    @Transactional
    public SportEvent saveSportEvent(SportEvent sportEvent) {
        if(sportEvent.getLocalisationPoint() != null) {
            sportEvent.getLocalisationPoint().setType(CUSTOM);
        }
        return repository.save(sportEvent);
    }
}
