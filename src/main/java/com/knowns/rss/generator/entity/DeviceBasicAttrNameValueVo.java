package com.knowns.rss.generator.entity;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 19:07
 */

/**
 * 设备信息类，对外暴露的基本信息
 *
 * @author liying22923
 *
 */
public class DeviceBasicAttrNameValueVo {

    /**
     * 设备基本属性展示名称
     */
    private String basicAttrDisplayName;

    /**
     * 设备属性值
     */
    private String basicAttrValue;

    public String getBasicAttrDisplayName() {
        return basicAttrDisplayName;
    }

    public void setBasicAttrDisplayName(String basicAttrDisplayName) {
        this.basicAttrDisplayName = basicAttrDisplayName;
    }

    public String getBasicAttrValue() {
        return basicAttrValue;
    }

    public void setBasicAttrValue(String basicAttrValue) {
        this.basicAttrValue = basicAttrValue;
    }

    @Override
    public String toString() {
        return "DeviceBasicAttrNameValueVo{" +
                "basicAttrDisplayName='" + basicAttrDisplayName + '\'' +
                ", basicAttrValue='" + basicAttrValue + '\'' +
                '}';
    }
}
