package com.codeknab.sportgeeks.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "localisation")
@Data
public class Localisation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "center_id")
    private LocalisationPoint center;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "localisation_id")
    private List<LocalisationPoint> polygonPoints;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "localisation_id")
    private List<LocalisationSportType> sportTypes;
}
