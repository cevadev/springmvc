package com.ceva.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionControllerTest {
    // ejemplo que lanza un excepcion al dividir un numero entre 0 pero es una excepcion no controlada
    @GetMapping("/stdExceptionTest")
    public String standardExceptionTest() {
        int n = 0;
        int j = 10 / n;
        System.out.println("j = " + j);

        return "home";
    }
}