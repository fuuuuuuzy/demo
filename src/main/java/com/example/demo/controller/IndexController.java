package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class IndexController {

//    @RequestMapping("/login")
    @RequestMapping("/login/{username}")
    @ResponseBody
//    public Boolean TestFunc(@RequestBody String username, @RequestBody String password) {
    public Boolean TestFunc(@PathVariable String username) {
        System.out.println(username);
//        System.out.println(password);
        return true;
    }

}
