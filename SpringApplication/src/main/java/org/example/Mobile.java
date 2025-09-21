package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
    private final Sim sim;
    public Mobile(@Qualifier("robi")Sim sim) {
        this.sim = sim;
    }

    void useSim(){
        sim.calling();
        sim.data();
    }
}
