package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "localisation_to_sport_type")
public class LocalisationSportType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private SportType sportType;
}
