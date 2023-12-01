package com.example.EcoApp.EcoRecicla.Apis;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.EcoApp.EcoRecicla.Models.User;
import com.example.EcoApp.EcoRecicla.Services.UserService;

@RestController()
@RequestMapping("/api/User")
public class UserApiController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody User user) {
        if(user!=null) {
            System.out.print(user.toString());
            userService.insert(user);
            String message = "User created successfully";
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            String message = "User not created";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        if(id > 0){
            if(userService.delete(id)){
                String message = "User deleted successfully";
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else {
                String message = "User not deleted";
                return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            }
        } else {
            String message = "Invalid user id";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody User user) {
        if(user!=null) {
            userService.update(user);
            String message = "User updated successfully";
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            String message = "User not updated";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}