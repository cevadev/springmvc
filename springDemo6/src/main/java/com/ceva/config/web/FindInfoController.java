package com.ceva.config.web;

import com.ceva.config.root.InfoNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FindInfoController {
    @GetMapping("/info/{id}")
    public String findInfo(@PathVariable int id, Model model) throws InfoNotFoundException {
        // simulamos la generacion de la excepcion
        if (id > 5)
            throw new InfoNotFoundException();
        model.addAttribute("id", id);
        return "info";
    }

    @GetMapping("/nullTest")
    public String nullPointerExceptionTest() {
        String str = null;
        // str es null, al llamar al metodo indexOf se producira una excrption
        int i = str.indexOf(" ");

        return "info";
    }

    // cuando se genera la excepcion InfoNotFoundException se invocara al metodo exceptionHandler
    // el cual llama al jsp exceptionErro.jsp
    @ExceptionHandler(InfoNotFoundException.class)
    public String exceptionHandler() {
        return "exceptionError";
    }
}

