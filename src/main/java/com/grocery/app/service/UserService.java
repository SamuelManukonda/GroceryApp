package com.grocery.app.service;

import com.grocery.app.model.User;
import com.grocery.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userUserRepository;

    public UserService(UserRepository userUserRepository) {
        this.userUserRepository = userUserRepository;
    }

    public void saveUser(User user){
        userUserRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userUserRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userUserRepository.findAll();
    }
}
