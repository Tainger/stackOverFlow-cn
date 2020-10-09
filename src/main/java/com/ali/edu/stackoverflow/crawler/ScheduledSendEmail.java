package com.ali.edu.stackoverflow.crawler;

import com.ali.edu.stackoverflow.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/9/7 9:10
 */
@Component
public class ScheduledSendEmail {

    @Autowired
    private HttpUtils httpUtils;

    //每五秒执行一次
    @Scheduled(fixedRate = 5000)
    public void sendEmail(){
        String html = httpUtils.getHtml("https://www.v2ex.com/recent?p=23084");
        System.out.println(html);
    }

}
