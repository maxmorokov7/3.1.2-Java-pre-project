package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "allUsers";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/userInfo";
    }


    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }


}
