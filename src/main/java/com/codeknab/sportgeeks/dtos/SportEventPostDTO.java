package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.Difficulty;
import com.codeknab.sportgeeks.enums.GenderOption;
import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class SportEventPostDTO {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime creationTime;

    private String description;

    @NotNull
    private Difficulty difficulty;

    @NotNull
    private GenderOption genderOption;

    private Double price;

    @NotNull
    private SportType sportType;

    @NotNull
    private Long organisatorId;

    private CustomLocalisationPointDTO customLocalisationPoint;

    @NotNull
    private Long predefinedLocalisationId;

}
