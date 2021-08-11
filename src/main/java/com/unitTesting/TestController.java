package com.unitTesting;

import com.unitTesting.beans.Bean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Bean1 bean1;

    @GetMapping("/getHello")
    public String getHello(){
        return bean1.printHello();
    }

}
