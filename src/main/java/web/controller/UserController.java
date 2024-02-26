package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
            return "userInfo";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }


    @GetMapping("/update")
    public String updateUserForm(@RequestParam("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/update")
    public String saveUpdatedUser(@ModelAttribute("user") @Valid User updatedUser, BindingResult bindingResult) {
        userService.updateUser(updatedUser);
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
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


