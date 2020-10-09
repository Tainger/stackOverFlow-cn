package com.ali.edu.stackoverflow;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JsoupTest {

    @Test
    public void testJsoupHtml(){
        try {
            Document document = Jsoup.parse(new URL("https://www.v2ex.com/t/706424#reply0"), 10000);
            String title = document.getElementsByTag("title").first().text();
            System.out.println(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsoupUrl(){
        //可以将String字符串       解析成Document对象
        String content = null;
        try {
            content = FileUtils.readFileToString(new File("c:\\Users"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(content);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
        //也可以把直接读取文件
    }
}
