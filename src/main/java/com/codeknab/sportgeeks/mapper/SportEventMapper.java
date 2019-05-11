package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.dtos.SportEventDTO;
import com.codeknab.sportgeeks.dtos.SportEventPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LocalisationMapper.class})
public abstract class SportEventMapper {
    @Mapping(target = "customLocalisationPoint", source = "localisationPoint")
    public abstract SportEventDTO toSportEventDTO(SportEvent sportEvent);

    @Mapping(target = "organisatorId", source = "sportEvent.organisator.id")
    @Mapping(target = "customLocalisationPoint", source = "sportEvent.localisationPoint")
    public abstract SportEventPostDTO toSportEventPostDTO(SportEvent sportEvent);

    @Mapping(target = "organisator", expression = "java(resolveOrganisator(sportEvent))")
    @Mapping(target = "localisationPoint", source = "sportEvent.customLocalisationPoint")
    public abstract SportEvent toSportEvent(SportEventPostDTO sportEvent);

    public User resolveOrganisator(SportEventPostDTO sportEvent) {
        return sportEvent.getOrganisatorId() == null
                ? null
                : User.builder()
                .id(sportEvent.getOrganisatorId())
                .build();
    }
}
