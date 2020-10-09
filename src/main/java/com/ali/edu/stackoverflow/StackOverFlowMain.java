package com.ali.edu.stackoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/9/7 8:59
 */

@SpringBootApplication
//开启定时框架
//@EnableScheduling
public class StackOverFlowMain {

    public static void main(String[] args) {
        SpringApplication.run(StackOverFlowMain.class,args);
    }
}
