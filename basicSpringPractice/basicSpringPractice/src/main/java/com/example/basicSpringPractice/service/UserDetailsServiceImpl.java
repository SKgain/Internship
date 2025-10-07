package com.example.basicSpringPractice.service;

import com.example.basicSpringPractice.entity.Customer;
import com.example.basicSpringPractice.entity.UserDetailsPrinciple;
import com.example.basicSpringPractice.exception.ResourceNotFoundException;
import com.example.basicSpringPractice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepository
                .findByEmail(username).orElseThrow(() -> new ResourceNotFoundException(username));


        return new UserDetailsPrinciple(customer);
    }
}
