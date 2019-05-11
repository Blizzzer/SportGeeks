package com.codeknab.sportgeeks.service;

import com.codeknab.sportgeeks.domain.Localisation;
import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.enums.SportType;
import com.codeknab.sportgeeks.repository.LocalisationRepository;
import com.codeknab.sportgeeks.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class LocalisationService {
    @Autowired
    private LocalisationRepository repository;

    @Transactional
    public List<Localisation> getFilteredLocalisations(
            Double maxLatitude,
            Double minLatitude,
            Double maxLongitude,
            Double minLongitude,
            SportType sportType
    ) {
        return repository.findAll().stream()
                .filter(localisation -> localisation.getSportTypes().stream()
                        .anyMatch(sportTypeEl -> sportTypeEl.getSportType() == sportType))
                .filter(localisation ->
                        localisation.getCenter().getLatitude() < maxLatitude
                                & localisation.getCenter().getLatitude() > minLatitude
                        )
                .filter(localisation ->
                                localisation.getCenter().getLongitude() < maxLongitude
                                        & localisation.getCenter().getLongitude() > minLongitude
                        )
                .collect(toList());
    }
}
