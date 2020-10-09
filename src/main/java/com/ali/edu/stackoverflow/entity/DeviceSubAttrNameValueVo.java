package com.ali.edu.stackoverflow.entity;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 19:10
 */

public class DeviceSubAttrNameValueVo {

    /**
     * 设备子属性名称
     */
    private String subAttrDisplayName;

    /**
     * 设备子属性值
     */
    private String subAttrValue;

    public String getSubAttrDisplayName() {
        return subAttrDisplayName;
    }

    public void setSubAttrDisplayName(String subAttrDisplayName) {
        this.subAttrDisplayName = subAttrDisplayName;
    }

    public String getSubAttrValue() {
        return subAttrValue;
    }

    public void setSubAttrValue(String subAttrValue) {
        this.subAttrValue = subAttrValue;
    }

    @Override
    public String toString() {
        return "DeviceSubAttrNameValueVo{" +
                "subAttrDisplayName='" + subAttrDisplayName + '\'' +
                ", subAttrValue='" + subAttrValue + '\'' +
                '}';
    }
}

