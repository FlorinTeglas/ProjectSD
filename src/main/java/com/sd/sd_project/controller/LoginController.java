package com.sd.sd_project.controller;

import com.sd.sd_project.model.User;
import com.sd.sd_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestParam String username, @RequestParam String password){
        return userService.login(username,password);
    }
}
