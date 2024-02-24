package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    public UserController() {
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "userInfo";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/users/new";
        }userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userInfo";
    }

    @PostMapping("/saveUpdatedUser")
    public String saveUpdatedUser(@ModelAttribute("user") @Valid User updatedUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }userService.updateUser(updatedUser);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteForm(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "deleteUser";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


