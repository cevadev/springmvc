package com.ceva.config.web;

import com.ceva.config.root.DataRepository;
import com.ceva.config.root.Person;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JdbcController {

    // con esta anotacion spring provee el repositorio de datos en dataRepository el cual
    // es usado por los metodos de este controlador
    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/jdbcList")
    public String jdbcList(Model model) {
        List<Person> list =  dataRepository.list();
        model.addAttribute("list", list);
        return "jdbcList";
    }

    @GetMapping("/jdbcForm")
    public String jdbcForm(Model model) {
        model.addAttribute("person", new Person());
        return "jdbcForm";
    }

    @PostMapping("/jdbcForm")
    public String jdbcPostForm(@Valid Person person, Errors errors, Model model) {
        if (errors.hasErrors())
            return "jdbcForm";

        dataRepository.save(person);
        return "redirect:/jdbcList";
    }

    @GetMapping("/jdbcDelete/{id_person}")
    public String jdbcDelete(@PathVariable int id_person) {
        dataRepository.delete(id_person);
        return "redirect:/jdbcList";
    }
}
