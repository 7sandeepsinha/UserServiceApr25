package dev.sandeep.UserService.service;

import dev.sandeep.UserService.config.BCryptEncoder;
import dev.sandeep.UserService.dto.UserLoginReqDTO;
import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptEncoder bCryptEncoder;

    public User save(User user) {
        String normalPassword = user.getPassword();
        String encryptedPassword = bCryptEncoder.encode(normalPassword);
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public User findById(int id) {
        return null;
    }

    public User login(UserLoginReqDTO reqDTO) throws Exception {
        User user = userRepository.findByEmail(reqDTO.getEmail());
        if(user == null) {
            throw new Exception("user does not exist");
        }
        if(bCryptEncoder.matches(reqDTO.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new Exception("password does not match");
        }
    }

    public List<User> findAll() {
        return null;
    }

    public List<User> findByRole(int roleId){
        return null;
    }
}
