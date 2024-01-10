package com.ceva.config.web;

import com.ceva.config.root.FormData;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(FormData data, Model model) {
        return "form";
    }

    /**
     * @Valid -> le indica a aspring que realize la validacion describa en  la clase FormData
     * Errors -> contiene los errores que se pueden producir al momento de validar los datos
     */
    @PostMapping("/form")
    public String post(@Valid FormData data, Errors errors, @RequestParam(defaultValue = "false") boolean chkRedirect, Model model) {
        if(chkRedirect)
            return "redirect:/";
        System.out.println("hasErrors: " + errors.hasErrors());
        if (errors.hasErrors()) {
            return "form";
        }

        // << Procesar la informacion >> ...

        return "form";
    }
}
