package com.ali.edu.stackoverflow.exception;

/**
 * 定义一个全局异常
 */
public class GlobalException extends RuntimeException {

    private final String msg;

    public GlobalException(String msg){
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage(){
        return msg;
    }
}
