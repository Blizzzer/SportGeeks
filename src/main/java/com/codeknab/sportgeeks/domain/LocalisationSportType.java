package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "localisation_to_sport_type")
public class LocalisationSportType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private SportType sportType;
}
