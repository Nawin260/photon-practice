package com.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/get")
    public String display(){
        return "Hello there";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        return "User ID: " + id;
    }
}
