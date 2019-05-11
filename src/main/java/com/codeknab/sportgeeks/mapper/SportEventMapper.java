package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.dtos.SportEventDTO;
import com.codeknab.sportgeeks.dtos.SportEventPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LocalisationMapper.class})
public abstract class SportEventMapper {
    public abstract SportEventDTO toSportEventDTO(SportEvent sportEvent);

    @Mapping(target = "organisatorId", source = "sportEvent.organisator.id")
    public abstract SportEventPostDTO toSportEventPostDTO(SportEvent sportEvent);

    @Mapping(target = "organisator", expression = "java(resolveOrganisator(sportEvent))")
    public abstract SportEvent toSportEvent(SportEventPostDTO sportEvent);

    public User resolveOrganisator(SportEventPostDTO sportEvent) {
        return sportEvent.getOrganisatorId() == null
                ? null
                : User.builder()
                .id(sportEvent.getOrganisatorId())
                .build();
    }
}
