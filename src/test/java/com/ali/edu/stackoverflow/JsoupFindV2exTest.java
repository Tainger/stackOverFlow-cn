package com.ali.edu.stackoverflow;


import com.ali.edu.stackoverflow.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsoupFindV2exTest {

    @Autowired
    private HttpUtils httpUtils;

    @Test
    public void crawlHtml(){

    }
}
