package com.knowns.rss.generator.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@ResponseBody
public class GlobeExceptionHandler {

    /**
     * 这个方法和我们写的controller一样
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(HttpServletRequest request,Exception e){

        e.printStackTrace();
        return "666";
    }

}
