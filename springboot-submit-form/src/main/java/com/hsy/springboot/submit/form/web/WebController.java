package com.hsy.springboot.submit.form.web;

import com.hsy.springboot.submit.form.bean.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
    @GetMapping("/person")
    public String greetingForm(Model model) {
        model.addAttribute("person", new PersonForm());
        return "person";
    }

    @PostMapping("/person")
    public String greetingSubmit(@ModelAttribute PersonForm person,Model model) {
        model.addAttribute("person", person);
        return "result";
    }
}
