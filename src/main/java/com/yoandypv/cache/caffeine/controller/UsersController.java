package com.yoandypv.cache.caffeine.controller;


import com.yoandypv.cache.caffeine.persistence.model.User;
import com.yoandypv.cache.caffeine.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UsersController {

    private  final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable("username") String userName) {
        return this.userService.findByUserName(userName);
    }

}
