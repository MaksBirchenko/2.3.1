package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.user.User;


@Controller
public class UserController {


    private final UserService userService;
@Autowired
    public UserController(UserService userDao) {
        this.userService = userDao;
    }

    @GetMapping(value = "/users")
    public String users(Model model) {

        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "useradd";
    }

    @PostMapping("/saveUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @PostMapping("/{id}")
    public String editUser(@ModelAttribute("user")  User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user")  User user) {
        userService.deleteUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String saveUser(@PathVariable("id") long id, Model model ) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "useredit";
    }


    @GetMapping(value = "/useredit")
    public String userEdit(Model model) {

        model.addAttribute("userEdit", userService.getAllUsers());
        return "users";
    }
}
