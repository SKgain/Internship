package org.example;

import org.example.config.BeanConfig;
import org.example.controller.SpringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

    SpringController springController = context.getBean(SpringController.class);
    springController.callService();
}
}
