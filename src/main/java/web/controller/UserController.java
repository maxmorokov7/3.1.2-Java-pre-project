package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.Service.UserServiceImpl;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    public UserController() {
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "allUsers";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "userInfo";
    }

    @PostMapping
    public String create(@ModelAttribute("user")User user) {
       userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

//    @GetMapping("/update")
//    public String updateUser(@ModelAttribute("newUser") User user){
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }

}
