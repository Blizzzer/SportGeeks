package com.codeknab.sportgeeks.mapper;

import com.codeknab.sportgeeks.domain.User;
import com.codeknab.sportgeeks.dtos.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public abstract class UserMapper {
    public abstract UserDTO toUserDTO(User user);

    public abstract User toUser(UserDTO user);
}
