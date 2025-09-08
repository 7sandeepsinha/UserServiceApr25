package dev.sandeep.UserService.controller;

import dev.sandeep.UserService.dto.UserLoginReqDTO;
import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginReqDTO reqDTO) throws Exception {
        return ResponseEntity.ok(userService.login(reqDTO));
    }
}
