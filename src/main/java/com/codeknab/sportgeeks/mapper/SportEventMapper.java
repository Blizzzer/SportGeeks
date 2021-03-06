package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.Localisation;
import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.dtos.SportEventDTO;
import com.codeknab.sportgeeks.dtos.SportEventListElementDTO;
import com.codeknab.sportgeeks.dtos.SportEventPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LocalisationMapper.class, ParticipationMapper.class})
public abstract class SportEventMapper {
    @Mapping(target = "customLocalisationPoint", source = "localisationPoint")
    public abstract SportEventDTO toSportEventDTO(SportEvent sportEvent);

    @Mapping(target = "organisatorId", source = "sportEvent.organisator.id")
    @Mapping(target = "customLocalisationPoint", source = "sportEvent.localisationPoint")
    @Mapping(target = "predefinedLocalisationId", source = "sportEvent.localisation.id")
    @Mapping(target = "id", source = "sportEvent.id")
    public abstract SportEventPostDTO toSportEventPostDTO(SportEvent sportEvent);

    @Mapping(target = "organisator", expression = "java(resolveOrganisator(sportEvent))")
    @Mapping(target = "localisationPoint", source = "sportEvent.customLocalisationPoint")
    @Mapping(target = "localisation", expression = "java(resolveLocalisation(sportEvent))")
    public abstract SportEvent toSportEvent(SportEventPostDTO sportEvent);

    public abstract List<SportEventListElementDTO> toSportEventListElementDTOs(List<SportEvent> sportEvents);

    @Mapping(target = "organisatorName", source = "organisator.name")
    @Mapping(target = "participationsNumber", expression = "java(sportEvent.getParticipations().stream().count())")
    public abstract SportEventListElementDTO toSportEventListElementDTO(SportEvent sportEvent);


    public User resolveOrganisator(SportEventPostDTO sportEvent) {
        return sportEvent.getOrganisatorId() == null
                ? null
                : User.builder()
                .id(sportEvent.getOrganisatorId())
                .build();
    }

    public Localisation resolveLocalisation(SportEventPostDTO sportEvent) {
        return sportEvent.getPredefinedLocalisationId() == null
                ? null
                : Localisation.builder()
                .id(sportEvent.getPredefinedLocalisationId())
                .build();
    }
}
