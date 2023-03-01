package com.kata.mvc.springbootmvc.controller;

import com.kata.mvc.springbootmvc.entity.User;
import com.kata.mvc.springbootmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    public UserService userService;

    @GetMapping()
    public String allUsers(ModelMap model) {
        model.addAttribute("usersAttribute", userService.getAllUsers());
        return "index";
    }
    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String save(Model model) {
        model.addAttribute("newUserAttribute", new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("newUserAttribute") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("newUserAttribute", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("newUserAttribute") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

