package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.exceptions.ResourceNotFoundException;
import com.codeknab.sportgeeks.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportEventService {
    @Autowired
    private SportEventRepository repository;

    public SportEvent getSingleSportEvent(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SportEvent", "id", id));
    }
}
