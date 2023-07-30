package com.knowns.rss.generator.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rocky
 * @ClassName TestController
 * @Description
 * @Create by rocky
 * @Date 2020/11/1 下午2:28
 */

@RestController
@RequestMapping("/api/v1/demo")
public class TestController {

    @PostMapping("getListInteger")
    public List<Integer> getListInteger(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return  list;
    }

    @PostMapping("getListString")
    public List<String> getListString(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        return  list;
    }

    @PostMapping("getMapStringInteger")
    public Map<String, Integer> getHashMapStringInteger(){
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        return  map;
    }

    @PostMapping("getMapStringString")
    public Map<String, String> getHashMapStringString(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        return  map;
    }

    @GetMapping("getJSONObject")
    public JSONObject getJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","value");
        jsonObject.put("demo","demo1");
        jsonObject.put("demo2","demo2");
        return jsonObject;
    }

    @GetMapping("getJSONArray")
    public JSONArray getJSONArray(){
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","value");
        jsonObject.put("demo","demo1");
        jsonObject.put("demo2","demo2");
        jsonArray.add(jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("key","value");
        jsonObject2.put("demo","demo1");
        jsonObject2.put("demo2","demo2");
        jsonArray.add(jsonObject2);

        jsonArray.add(jsonObject2);
        return jsonArray;
    }
}
