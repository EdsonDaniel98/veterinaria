package com.prueba.examen.veterinaria.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(CustomException.class)
    public ErrorMensaje customException(CustomException exception){
        return new ErrorMensaje("CustomException", exception.getMessage());
    }
}
