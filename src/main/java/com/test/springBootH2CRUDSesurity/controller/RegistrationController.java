package com.test.springBootH2CRUDSesurity.controller;

import com.test.springBootH2CRUDSesurity.modal.Role;
import com.test.springBootH2CRUDSesurity.modal.User;
import com.test.springBootH2CRUDSesurity.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
    public String addUser(@ModelAttribute(value = "user") @Valid User user, Model model, BindingResult bindingResult) {
        User usernameDb = userCrudRepository.findByUsername(user.getUsername());
        if (usernameDb != null) {
            model.addAttribute("message", "User exist!!");
            return "registration";
        }

        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRoles(roles);
        user.setActive(true);
        userCrudRepository.save(user);


        return "redirect:/login";
    }
}
