package com.ceva.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Clase controller que agrega a model una cadena con fecha y hora actual
 */
@Controller
public class TestTimeController {

    @GetMapping("/testTime")
    public String testTime(Model model) {
        /**
         * lo attribute que se guardan en el model terminan en el request de la peticion
         * por lo tanto es facil usarlo en la vista por medio de jstl
         */
        model.addAttribute("curTime", new java.util.Date().toString());

        return "testTime";
    }
}
