package com.test.springBootH2CRUDSesurity.controller;

import com.test.springBootH2CRUDSesurity.modal.Role;
import com.test.springBootH2CRUDSesurity.modal.User;
import com.test.springBootH2CRUDSesurity.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute(value = "user") User user, Model model) {
        User usernameDb = userCrudRepository.findByUsername(user.getUsername());
        if (usernameDb != null) {
            model.addAttribute("message", "User exist!!");
            return "registration";
        }
        Set<Role> roles = new HashSet<>();
        user.setActive(true);
        roles.add(Role.USER);
        user.setRoles(roles);
        /*user.setRoles(Collections.singleton(Role.USER));*/
        userCrudRepository.save(user);
        return "redirect:/login";
    }
}
