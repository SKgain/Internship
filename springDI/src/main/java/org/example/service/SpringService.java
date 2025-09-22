package org.example.service;

import org.example.repository.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringService {
    @Autowired
    private SpringRepository springRepository;

    public void getService() {
        System.out.println("Spring Service is called, Now I am calling spring repository");
        springRepository.getRepository();
    }

}
