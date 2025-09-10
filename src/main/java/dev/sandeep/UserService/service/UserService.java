package dev.sandeep.UserService.service;

import dev.sandeep.UserService.config.BCryptEncoder;
import dev.sandeep.UserService.dto.UserLoginReqDTO;
import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.repository.UserRepository;
import dev.sandeep.UserService.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptEncoder bCryptEncoder;
    @Autowired
    private JwtService jwtService;

    public String save(User user) {
        String normalPassword = user.getPassword();
        String encryptedPassword = bCryptEncoder.encode(normalPassword);
        user.setPassword(encryptedPassword);
        User savedUser =  userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());
        return token;
    }

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User findById(int id) {
        return null;
    }

    public String login(UserLoginReqDTO reqDTO) throws Exception {
        User user = userRepository.findFirstByEmail(reqDTO.getEmail());
        if(user == null) {
            throw new Exception("user does not exist");
        }
        if(bCryptEncoder.matches(reqDTO.getPassword(), user.getPassword())) {
            String token = jwtService.generateToken(user.getEmail());
            return token;
        } else {
            throw new Exception("password does not match");
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByRole(int roleId){
        return null;
    }
}
