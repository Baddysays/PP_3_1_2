package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/update";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

}

