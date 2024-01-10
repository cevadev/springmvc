package com.ceva.config.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Esta clase con anotacion @ControllerAdvice
 */
@ControllerAdvice
public class NullPointerExceptionAdvice {

    // este metodo sera invocado cuando se presente esta excepcion en cualquier parte de la applicacion
    @ExceptionHandler(NullPointerException.class)
    public String nullHandler() {
        return "nullPointerException";
    }
}