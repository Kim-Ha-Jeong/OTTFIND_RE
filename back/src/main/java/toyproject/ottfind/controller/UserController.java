package toyproject.ottfind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import toyproject.ottfind.domain.User;
import toyproject.ottfind.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> findAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public User signUp(@RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.join(user);
        return user;
    }
}