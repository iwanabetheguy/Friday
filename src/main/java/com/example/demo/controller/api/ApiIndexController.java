package com.example.demo.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.baen.PostFridayInfoRequest;
import com.example.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ApiIndexController {
    private static final Logger logger = LoggerFactory.getLogger(ApiIndexController.class);

    @Autowired
    private FridayService fridayService;

    @RequestMapping("/index")
    public String index()
    {
        return "Friday-index";
    }

    // Friday初始化
    @GetMapping("/friday/initialize")
    public String friday_initialize() {
        return fridayService.initialize();
    }

    // Friday开始
    @PostMapping("/friday/start")
    public Object friday_start(@RequestBody PostFridayInfoRequest request) {
        logger.info("request-->>{}", JSON.toJSONString(request));
        return JSONObject.parse(JSON.toJSONString(fridayService.start(request), SerializerFeature.DisableCircularReferenceDetect));
    }

    @RequestMapping("/test")
    public ArrayList<String> test() {
        ArrayList<String> test =new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            test.add("第"+i+"项");
        }
        System.out.println(test.size());
        return test;
    }
}
