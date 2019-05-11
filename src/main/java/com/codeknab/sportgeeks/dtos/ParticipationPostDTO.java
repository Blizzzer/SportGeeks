package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.ParticipationProbability;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ParticipationPostDTO {

    private Long id;

    private ParticipationProbability probability;

    private String additionalInfo;

    @NotNull
    private Long userId;
}
