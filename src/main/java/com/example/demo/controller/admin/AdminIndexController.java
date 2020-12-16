package com.example.demo.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminIndexController {
    @RequestMapping("/index")
    public String index(){
        return "{\"code\":200,\"msg\":\"你好？\"}";
    }
}
