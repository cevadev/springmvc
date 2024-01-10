package com.ceva.config.web;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryStringParamController {

    /**
     * @RequestParam no tiene nombre por lo que toma el nombre del argumento param1
     * defaultValue -> en caso que en el query string no exista param1, tomara el valor por defecto
     *                 indicado en defaultValue
     * @param model
     * @return
     */
    @GetMapping("/qsTest")
    public String getTest(@RequestParam(defaultValue="") String param1, @RequestParam(defaultValue="") String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "qsTest";
    }

    @PostMapping("/qsTest")
    public String postTest(@RequestParam Map<String,String> params, Model model) {
        model.addAttribute("param1", params.get("param1"));
        model.addAttribute("param2", params.get("param2"));
        return "qsTest";
    }

    @GetMapping("/qsTest2")
    public String qsTest2(@RequestParam int param1, Model model) {
        model.addAttribute("param1", param1);
        return "qsTest";
    }
}