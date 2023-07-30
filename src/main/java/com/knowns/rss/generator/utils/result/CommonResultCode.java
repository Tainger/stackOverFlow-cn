package com.knowns.rss.generator.utils.result;

import com.knowns.rss.generator.utils.result.interfaces.IErrorCode;

public enum CommonResultCode implements IErrorCode {

    /**
     * 调用成功
     */
    SUCCESS("successful."),
    /**
     * 未定义错误
     */
    UNDEFINED_ERROR("undefined error:%s.");

    private String message;

    private CommonResultCode(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.name().toLowerCase();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
