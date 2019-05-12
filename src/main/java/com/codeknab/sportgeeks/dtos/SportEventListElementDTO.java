package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SportEventListElementDTO {
    private Long id;

    private LocalDateTime startTime;

    private Double price;

    private LocalisationDTO localisation;

    private String organisatorName;

    private long participationsNumber;

    private SportType sportType;
}
