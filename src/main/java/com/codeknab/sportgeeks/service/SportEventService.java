package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.enums.Gender;
import com.codeknab.sportgeeks.enums.GenderOption;
import com.codeknab.sportgeeks.enums.LocalisationPointType;
import com.codeknab.sportgeeks.enums.SportType;
import com.codeknab.sportgeeks.exceptions.ResourceNotFoundException;
import com.codeknab.sportgeeks.repository.SportEventRepository;
import io.vavr.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeknab.sportgeeks.enums.LocalisationPointType.CUSTOM;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Service
public class SportEventService {
    @Autowired
    private SportEventRepository repository;

    public SportEvent getSingleSportEvent(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SportEvent", "id", id));
    }

    @Transactional
    public SportEvent saveSportEvent(SportEvent sportEvent) {
        if (sportEvent.getLocalisationPoint() != null) {
            sportEvent.getLocalisationPoint().setType(CUSTOM);
        }
        return repository.save(sportEvent);
    }

    public void deleteSportEvent(Long id) {
        repository.deleteById(id);
    }

    public List<SportEvent> getFilteredSportEvents(
            Double maxLatitude,
            Double minLatitude,
            Double maxLongitude,
            Double minLongitude,
            SportType sportType
    ) {
        return repository.findAllBySportType(sportType).stream()
                .filter(event -> nonNull(event.getLocalisation()))
                .filter(event ->
                        event.getLocalisation().getCenter().getLatitude() < maxLatitude
                                & event.getLocalisation().getCenter().getLatitude() > minLatitude
                )
                .filter(event ->
                        event.getLocalisation().getCenter().getLongitude() < maxLongitude
                                & event.getLocalisation().getCenter().getLongitude() > minLongitude
                )
                .collect(toList());
    }

    public List<SportEvent> getByUserIdSorted(Long userId) {
        return repository.findAll().stream().filter(event -> event.getParticipations()
                .stream()
                .anyMatch(participation -> participation.getUser().getId() == userId)
        ).sorted(Comparator.comparing(SportEvent::getStartTime)).collect(toList());
    }

    public SportEvent getSingleByUserIdSorted(Long userId) {
        return repository.findAll().stream().filter(event -> event.getParticipations()
                .stream()
                .anyMatch(participation -> participation.getUser().getId() == userId)
        ).sorted(Comparator.comparing(SportEvent::getStartTime))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("SportEvent", "userId", userId));
    }

}
