package com.codeknab.sportgeeks.dtos;

import lombok.Data;

@Data
public class CustomLocalisationPointDTO {

    private Long id;

    private Double latitude;

    private Double longitude;

    private String name;
}
