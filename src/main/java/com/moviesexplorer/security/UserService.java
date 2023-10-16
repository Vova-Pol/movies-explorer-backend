package com.moviesexplorer.security;

import com.moviesexplorer.jpa.UserRepository;
import com.moviesexplorer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User '%s' not found", username)
                )
        );

        return UserDetailsImpl.build(foundUser);
    }
}
