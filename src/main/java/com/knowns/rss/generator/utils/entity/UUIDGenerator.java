package com.knowns.rss.generator.utils.entity;

import java.util.UUID;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-27
 * @Time: 22:52
 */
public class UUIDGenerator {

    private UUIDGenerator(){}
    /**
     * 获取32位UUID字符串     
     *
     * @return     
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取32位UUID大写字符串
     *
     * @return
     */
    public static String getUpperCaseUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
