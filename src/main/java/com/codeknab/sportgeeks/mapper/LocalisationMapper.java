package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.Localisation;
import com.codeknab.sportgeeks.domain.LocalisationSportType;
import com.codeknab.sportgeeks.dtos.LocalisationDTO;
import com.codeknab.sportgeeks.enums.SportType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring")
public abstract class LocalisationMapper {
    @Mapping(target= "sportTypes", expression = "java(localisationSportTypesToSportTypes(localisation))")
    public abstract LocalisationDTO toLocalisationDTO(Localisation localisation);

    public List<SportType> localisationSportTypesToSportTypes(Localisation localisation) {
        return localisation.getSportTypes()
                .stream()
                .map(LocalisationSportType::getSportType)
                .collect(toList());
    }

    public abstract List<LocalisationDTO> toLocalisationDTOs(List<Localisation> localisations);
}
