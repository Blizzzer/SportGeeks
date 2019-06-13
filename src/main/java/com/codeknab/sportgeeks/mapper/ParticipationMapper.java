package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.dtos.ParticipationDTO;
import com.codeknab.sportgeeks.dtos.ParticipationPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public abstract class ParticipationMapper {
    @Mapping(target = "userId", source = "user.id")
    public abstract ParticipationDTO toParticipationDTO(Participation participation);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "id", source = "participation.id")
    public abstract ParticipationPostDTO toParticipationPostDTO(Participation participation);

    public abstract Participation toParticipation(ParticipationDTO participation);

    @Mapping(target = "user", expression = "java(resolveUser(participation))")
    public abstract Participation toParticipation(ParticipationPostDTO participation);

    public User resolveUser(ParticipationPostDTO participation) {
        return participation.getUserId() == null
                ? null
                : User.builder()
                .id(participation.getUserId())
                .build();
    }
}
