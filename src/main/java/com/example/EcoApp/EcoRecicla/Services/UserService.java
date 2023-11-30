package com.example.EcoApp.EcoRecicla.Services;
import java.util.*;

import com.example.EcoApp.EcoRecicla.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcoApp.EcoRecicla.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User insert(User p) {
        try {
            return userRepository.save(p);
        } catch (Exception e) {
            return null;
        }
    }
    public boolean delete(int id) {
        userRepository.deleteById(id);
        return false;
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    public User update(User p) {
        try {
            return userRepository.save(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}
