package com.seeds.neuroapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomExceptionDto {

    private Date timestamp;
    private int status;
    private String message;
    private List<ValidationErroDto> errors;

    public CustomExceptionDto(String message, int status){
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }

    public CustomExceptionDto(List<ValidationErroDto> errors, int status){
        this.errors = errors;
        this.status = status;
        this.timestamp = new Date();
    }
}
