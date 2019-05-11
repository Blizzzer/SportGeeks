package com.codeknab.sportgeeks.dtos;

import com.codeknab.sportgeeks.enums.SportType;
import lombok.Data;

import java.util.List;

@Data
public class LocalisationDTO {
    private Long id;

    private String name;

    private String description;

    private LocalisationPointDTO center;

    private List<LocalisationPointDTO> polygonPoints;

    private List<SportType> sportTypes;
}
