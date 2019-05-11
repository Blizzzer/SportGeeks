package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private String phoneNumber;

    private String description;

    private int age;

    @NotNull
    private String userUID;

    @NotNull
    private Gender gender;
}
