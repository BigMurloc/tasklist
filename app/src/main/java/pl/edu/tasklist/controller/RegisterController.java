package pl.edu.tasklist.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.tasklist.entity.User;
import pl.edu.tasklist.service.UserService;

@RestController()
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseBody
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

}
