package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.dtos.SportEventDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", imports = UserMapper.class)
public abstract class SportEventMapper {
    public abstract SportEventDTO toSportEventDTO(SportEvent sportEvent);

    public abstract SportEvent toSportEvent(SportEventDTO sportEvent);
}
