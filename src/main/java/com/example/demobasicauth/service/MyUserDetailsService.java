package com.example.demobasicauth.service;

import com.example.demobasicauth.entity.UserApp;
import com.example.demobasicauth.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserApp userApp = userRepository.getUserByUsername(username);
        return User.builder()
                .username(userApp.getUsername())
                .password(userApp.getPassword())
                .build();
    }
}
