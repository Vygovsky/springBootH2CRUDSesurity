package com.test.springBootH2CRUDSesurity.controller;

import com.test.springBootH2CRUDSesurity.modal.User;
import com.test.springBootH2CRUDSesurity.repository.UserCrudRepository;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private UserCrudRepository repository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = repository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User exist!!");
            return "registration";
        }
        return "redirect:/login";
    }
}
