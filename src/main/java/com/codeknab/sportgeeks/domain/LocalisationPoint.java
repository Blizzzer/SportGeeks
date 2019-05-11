package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.LocalisationPointType;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "localisation_point")
public class LocalisationPoint {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private Double longitude;

    private Double latitude;

    @Enumerated(STRING)
    private LocalisationPointType type;
}
