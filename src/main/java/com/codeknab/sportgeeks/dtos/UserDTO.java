package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.Gender;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String description;

    private int age;

    private String userUID;

    private Gender gender;
}
