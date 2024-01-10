package com.ceva.config.web;

import com.ceva.config.root.DataRepository;
import com.ceva.data.Person;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controler para Hibernate
 */
@Controller
public class HibernateController {
    @Autowired
    @Qualifier("hibernate")
    private DataRepository dataRepository;

    @GetMapping("/hibernateList")
    public String hibernateList(Model model) {
        List<Person> list =  dataRepository.list();
        model.addAttribute("list", list);
        return "hibernateList";
    }

    @GetMapping("/hibernateForm")
    public String hibernateForm(Model model) {
        model.addAttribute("person", new Person());
        return "hibernateForm";
    }

    @PostMapping("/hibernateForm")
    public String hibernatePostForm(@Valid Person person, Errors errors, Model model) {
        if (errors.hasErrors())
            return "hibernateForm";

        dataRepository.save(person);
        return "redirect:/hibernateList";
    }

    @GetMapping("/hibernateDelete/{id_person}")
    public String hibernateDelete(@PathVariable int id_person) {
        dataRepository.delete(id_person);
        return "redirect:/hibernateList";
    }

}
