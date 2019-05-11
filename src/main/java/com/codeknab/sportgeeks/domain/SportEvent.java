package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.Difficulty;
import com.codeknab.sportgeeks.enums.GenderOption;
import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sport_event")
@Data
public class SportEvent {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    private String description;

    @Column(name = "difficulty_level")
    private Difficulty difficulty;

    @Column(name = "gender")
    private GenderOption genderOption;

    private Double price;

    @Column(name = "sport_type")
    private SportType sportType;
}
