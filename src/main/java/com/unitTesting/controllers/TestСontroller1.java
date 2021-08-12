package com.unitTesting.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestСontroller1 {

    @RequestMapping(method = RequestMethod.GET, value = "/simpleGetRequest",
            produces={"application/json"})
    public ResponseEntity<String> simpleGetRequest(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRequestWithPathVariable/{message}",
            produces={"application/json"})
    public ResponseEntity<String> getRequestWithPathParam(@PathVariable String message){
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRequestWithRequestParam",
            produces={"application/json"})
    public ResponseEntity<String> getRequestWithRequestParam(@RequestParam String message){
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
