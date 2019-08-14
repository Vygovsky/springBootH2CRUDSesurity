/*
package com.test.springBootH2CRUDSesurity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {
    @Value("${welcome.message}")
    private String welcome;

    private List<String> task = Arrays.asList("W, e, l, l, c, o, m, e");

    @GetMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute("message", welcome);
        model.addAttribute("task", task);
        return "welcome";
    }

}
*/
