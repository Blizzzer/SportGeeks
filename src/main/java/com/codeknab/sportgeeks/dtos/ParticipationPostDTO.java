package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.ParticipationProbability;
import lombok.Data;

@Data
public class ParticipationPostDTO {

    private Long id;

    private ParticipationProbability probability;

    private String additionalInfo;

    private Long userId;
}
