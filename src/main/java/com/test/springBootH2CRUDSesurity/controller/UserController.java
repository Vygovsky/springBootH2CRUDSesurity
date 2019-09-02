package com.test.springBootH2CRUDSesurity.controller;

import com.test.springBootH2CRUDSesurity.modal.User;
import com.test.springBootH2CRUDSesurity.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserCrudRepository userCrudRepository;

    @Autowired
    public UserController(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @GetMapping("/singup")
    public String singUpForm(User user, Model model) {
        model.addAttribute("users", userCrudRepository.findAll());
        return "index";
    }

    @PostMapping("/adduser")
    public String addUserForm(@Valid @ModelAttribute(value = "user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "adduser";
        }
        //нет самый первый раз, здесь уже ты возвращаешся если ошибки есть
        userCrudRepository.save(user);
        model.addAttribute("users", userCrudRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        User user = userCrudRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id : " + id));
        model.addAttribute("user", user);
        return "updateuser";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User userUpdate, BindingResult result, Model model) {
        if (result.hasErrors()) {
            userUpdate.setId(id);
            return "updateuser";
        }

        userCrudRepository.save(userUpdate);
        model.addAttribute("users", userCrudRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userCrudRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id : " + id));
        userCrudRepository.delete(user);
        model.addAttribute("users", userCrudRepository.findAll());
        return "index";
    }


}
