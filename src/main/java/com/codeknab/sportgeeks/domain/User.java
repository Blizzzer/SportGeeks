package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String description;

    private int age;

    @Column(name = "user_UID")
    private String userUID;

    @Enumerated(STRING)
    private Gender gender;
}
