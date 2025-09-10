package dev.sandeep.UserService.controller;

import dev.sandeep.UserService.dto.UserLoginReqDTO;
import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody UserLoginReqDTO reqDTO) throws Exception {
        return ResponseEntity.ok(userService.login(reqDTO));
    }

}
