package com.ceva.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que maneja las peticiones del url raiz /
 */
@Controller
public class HomeController {
    /**
     * el metodo home atendera las peticiones hechas al url raiz
     * este metodo retorna el string home, que viene a ser el nombre de la vista
     * esto hara que se invoque al viewResolver() configurado en WebConfig para que la peticion
     * sea atendida por el jsp en WEB-INF/views/home.jsp
     */
    @GetMapping("/")
    public String home() {
        // nombre de la vista (WEB-INF/views/home.jsp) que mostrara la informacion de acuerdo a
        // la operaciones que haya realizado.
        return "home";
    }
}
