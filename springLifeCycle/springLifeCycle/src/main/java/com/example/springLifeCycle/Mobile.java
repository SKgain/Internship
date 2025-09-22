package com.example.springLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    private Sim sim;

    public Mobile() {
        System.out.println("1. Mobile bean: created mobile bean");
    }
    @Autowired
    public void setSim(Sim sim) {
        this.sim = sim;

        System.out.println("2. Mobile bean: dependency injected");
    }

    @PostConstruct
    public void init() {
        System.out.println("3. Mobile bean: Post Construct method called");
    }

    void fun(){
        sim.calling();
    }

    @PreDestroy
    public void destroy(){
        System.out.println("5. Mobile bean: Pre Destroy method called");
    }
}
