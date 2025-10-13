package com.example.bank.service;

import com.example.bank.entity.User;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.model.UserDetailsPrinciple;
import com.example.bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException{

        User user = userRepository
                .findByEmail(username).orElseThrow(() -> new ResourceNotFoundException(username));


        return new UserDetailsPrinciple(user);
    }
}
