package com.ali.edu.stackoverflow;


import com.ali.edu.stackoverflow.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class JSoupThreeParseWayTest {

    /**
     * 1.根据id查询元素getElementById
     */
    @Test
    public void testJsoupUrlByDom(){
        String str = "字段 %s, 爬取内容：%s";
        HttpUtils httpUtils = new HttpUtils();
        String html = httpUtils.getHtml("https://www.v2ex.com/t/114835");
        Document document = Jsoup.parse(html);
        //根据标签名
        String title = document.getElementsByTag("title").text();
//        1.根据id查询元素getElementById
//        2.根据标签获取元素getElemenyByTag
//        3.根据class获取元素getElementByClass
//        4.根据属性获取元素getElementByAttribute
        Elements tag = document.getElementsByClass("tag");
        System.out.println(String.format(str,"tag",tag.text()));
        Elements reply_content = document.getElementsByClass("reply_content");
        String text = reply_content.text();
        String[] s = text.split(" ");
        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println(String.format(str,"reply",text));
    }

    @Test
    public void testJsoupUrlBySelector(){
        String str = "字段 %s, 爬取内容：%s";
        HttpUtils httpUtils = new HttpUtils();
        String html = httpUtils.getHtml("https://www.v2ex.com/t/114835");
        Document document = Jsoup.parse(html);
        document.select("");
    }

    @Test
    public void testJsoupUrlBySelectorAnd(){
        String str = "字段 %s, 爬取内容：%s";
        HttpUtils httpUtils = new HttpUtils();
        String html = httpUtils.getHtml("https://www.v2ex.com/t/114835");
        Document document = Jsoup.parse(html);
        Elements select = document.select("div#r_1114273");

    }
}
