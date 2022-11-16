package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userService.showAllUsers());
        return "users/list";
    }

    @GetMapping("/show")
    public String show(@RequestParam(name = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserByUd(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("user", userService.getUserByUd(id));
        return "users/editUser";
    }


    @PatchMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/editUser";
        }
        userService.update(user, user.getId());
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
