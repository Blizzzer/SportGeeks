package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.Participation;
import com.codeknab.sportgeeks.dtos.ParticipationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public abstract class ParticipationMapper {
    public abstract ParticipationDTO toParticipationDTO(Participation participation);

    public abstract Participation toParticipation(ParticipationDTO participation);
}
