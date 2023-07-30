package com.knowns.rss.generator.utils.result.interfaces;

public interface IErrorCode {
    /**
     * 错误编码
     *
     * @return 返回错误码
     */
    String getCode();

    /**
     * 错误内容
     *
     * @return 返回错误具体信息
     */
    String getMessage();
}
