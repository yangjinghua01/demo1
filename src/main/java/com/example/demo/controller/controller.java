package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@Controller
public class controller {

    @GetMapping("/upload")
    public String upload(){

        System.out.println("aaaaaaaa");
        return "upload";
    }
}
