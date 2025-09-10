package dev.sandeep.UserService.controller;

import dev.sandeep.UserService.dto.UserLoginReqDTO;
import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}
