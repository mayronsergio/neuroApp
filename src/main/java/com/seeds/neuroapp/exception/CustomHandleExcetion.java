package com.seeds.neuroapp.exception;

import com.seeds.neuroapp.dto.CustomExceptionDto;
import com.seeds.neuroapp.dto.ValidationErroDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomHandleExcetion extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ValidationErroDto> validationErros = new ArrayList<>();
        ex.getFieldErrors().forEach(error -> validationErros.add(new ValidationErroDto(error.getField(), error.getDefaultMessage())));
        CustomExceptionDto exceptionDto = new CustomExceptionDto(validationErros, HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex){
        CustomExceptionDto exceptionDto = new CustomExceptionDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleBadRequestException(ResourceNotFoundException ex){
        CustomExceptionDto exceptionDto = new CustomExceptionDto(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
