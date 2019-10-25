package com.sd.sd_project.controller;

import com.sd.sd_project.model.User;
import com.sd.sd_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AdminUserController {

    @Autowired
    UserService userService;


    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }
}
