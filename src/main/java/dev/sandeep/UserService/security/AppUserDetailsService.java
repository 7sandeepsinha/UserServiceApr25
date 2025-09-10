package dev.sandeep.UserService.security;

import dev.sandeep.UserService.model.User;
import dev.sandeep.UserService.repository.UserRepository;
import dev.sandeep.UserService.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Spring does not understand our custom service classes
//Spring understands UserDetailsService --- which is in real world equivalent to a class holding user specific service layer methods
//UserDetailsService is a wrapper, which will wrap our actual UserService class
@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserService userService;

    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        return new AppUserDetails(user);
    }
}
