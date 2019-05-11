package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.Difficulty;
import com.codeknab.sportgeeks.enums.GenderOption;
import com.codeknab.sportgeeks.enums.SportType;

import java.time.LocalDateTime;

public class SportEventDTO {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime creationTime;

    private String description;

    private Difficulty difficulty;

    private GenderOption genderOption;

    private Double price;

    private SportType sportType;
}