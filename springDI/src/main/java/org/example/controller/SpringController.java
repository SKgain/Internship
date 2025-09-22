package org.example.controller;

import org.example.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpringController {
    private SpringService springService;

    @Autowired
    public void setSpringService(SpringService springService) {
        this.springService = springService;
    }


    public void callService() {
        System.out.println("Hello I am spring controller,now I am calling spring service");
        springService.getService();
    }
}
