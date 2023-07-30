package com.knowns.rss.generator.exception;

/**
 * 定义一个全局异常
 * @author rocky
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
