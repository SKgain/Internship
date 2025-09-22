package com.example.springLifeCycle;

import org.springframework.stereotype.Component;

@Component
public class GP implements Sim{

    public GP(){
        System.out.println("1. Gp bean: created gp bean");
    }

    @Override
    public void calling() {
        System.out.println("4. Calling from GP");
    }
}
