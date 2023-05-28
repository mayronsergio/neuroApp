package com.seeds.neuroapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErroDto {

    private String field;
    private String message;
}
