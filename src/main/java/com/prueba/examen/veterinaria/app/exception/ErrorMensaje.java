package com.prueba.examen.veterinaria.app.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ErrorMensaje {
    private String type;
    private String message;

    public ErrorMensaje() {
    }

    public ErrorMensaje(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void throwError(Errors errors){
        String message = "";
        int index = 0;
        for (ObjectError r: errors.getAllErrors()){
            if (index > 0){
                message += " | ";

            }
            message += String.format("Parametro: %s - Message: %s", r.getObjectName(), r.getDefaultMessage());
        }
        throw new CustomException(message);
    }
}
