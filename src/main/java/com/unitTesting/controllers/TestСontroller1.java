package com.unitTesting.controllers;

import com.unitTesting.classes.Info;
import com.unitTesting.exceptions.RestException;
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


    @RequestMapping(method = RequestMethod.PUT, value = "/sendRequestBody",
            produces={"application/json"})
    public ResponseEntity<Info> sendRequestBody(@RequestBody Info info){
        info.setTitle("responseTitle");
        return ResponseEntity.ok(info);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRequestWithException1",
            produces={"application/json"})
    public ResponseEntity getRequestWithException1(@RequestParam Boolean throwException) throws Exception {
        if(throwException.equals(Boolean.TRUE))
            throw new RestException("Rest Exception");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRequestWithException2",
            produces={"application/json"})
    public ResponseEntity getRequestWithException2(@RequestParam Boolean throwException) throws Exception {
        if(throwException.equals(Boolean.TRUE))
            throw new RuntimeException("Runtime Exception");
        return ResponseEntity.ok().build();
    }



}
