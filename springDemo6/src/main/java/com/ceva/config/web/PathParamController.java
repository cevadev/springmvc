package com.ceva.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PathParamController {

    @GetMapping("/pathParam/{name}")
    public String pathParamTest(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "pathParam";
    }
}