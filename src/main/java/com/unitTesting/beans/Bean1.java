package com.unitTesting.beans;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {

    public String printHello(){
        System.out.println("Hello from Bean1");
        return "Hello from Bean1";
    }
}
