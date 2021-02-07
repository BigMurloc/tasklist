package pl.edu.tasklist.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.tasklist.entity.User;
import pl.edu.tasklist.service.UserService;

@RestController("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    @ResponseBody
    public User saveUser(@RequestBody User user){
        User userResponse = userService.save(user);
        return userResponse;
    }

}
