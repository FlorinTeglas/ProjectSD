package com.sd.sd_project.service;

import com.sd.sd_project.model.User;
import com.sd.sd_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public User login(String username, String password){
        return userRepository.findByUsernameAndPassword(username,password);

    }
}
