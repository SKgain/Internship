package org.example;

import org.springframework.stereotype.Component;

@Component
public class Robi implements Sim {

    @Override
    public void data() {
        System.out.println("Data from Robi");
    }
    @Override
    public void calling(){
        System.out.println("Calling from Robi");
    }
}
