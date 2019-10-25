package com.sd.sd_project.repository;

import com.sd.sd_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByUsernameAndPassword(String username, String password);
}
