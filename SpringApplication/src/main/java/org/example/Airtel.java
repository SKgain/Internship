package org.example;

import org.springframework.stereotype.Component;

@Component
public class Airtel implements Sim{
    @Override
    public void calling() {
        System.out.println("Calling from Airtel");
    }
    @Override
    public void data() {
        System.out.println("Data from Airtel");
    }
}
