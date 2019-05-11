package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.ParticipationProbability;
import lombok.Data;

@Data
public class ParticipationDTO {

    private Long id;

    private ParticipationProbability probability;

    private String additionalInfo;

    private UserDTO user;
}
