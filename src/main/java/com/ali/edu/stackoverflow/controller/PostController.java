package com.ali.edu.stackoverflow.controller;



import com.ali.edu.stackoverflow.utils.HttpUtils;
import com.ali.edu.stackoverflow.utils.result.PlainResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/device")
public class PostController {

    @Autowired
    private HttpUtils httpUtils;

    @GetMapping("get")
    public PlainResult testParam(){
        Map<String, Object> map = new HashMap<>();
        map.put("data","1");
        map.put("user","2");
        map.put("post","3");
        return new PlainResult(map);
    }




}
