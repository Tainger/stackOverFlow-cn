package com.knowns.rss.generator.entity;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 19:07
 */

import java.util.Map;

/**
 * 新增设备信息类
 *
 * @author liying22923
 *
 */
public class DeviceAddParam {

    /**
     * 设备必填的3个属性
     */
    private DeviceCommonNameAttrs deviceCommonNameAttrs;

    /**
     * 设备基本属性
     */
    private Map<String, DeviceBasicAttrNameValueVo> basicAttrVoMap;

    /**
     * 设备扩展属性
     */
    private Map<String, DeviceExtendAttrNameValueVo> extendAttrVoMap;

    public DeviceCommonNameAttrs getDeviceCommonNameAttrs() {
        return deviceCommonNameAttrs;
    }

    public void setDeviceCommonNameAttrs(DeviceCommonNameAttrs deviceCommonNameAttrs) {
        this.deviceCommonNameAttrs = deviceCommonNameAttrs;
    }

    public Map<String, DeviceBasicAttrNameValueVo> getBasicAttrVoMap() {
        return basicAttrVoMap;
    }

    public void setBasicAttrVoMap(Map<String, DeviceBasicAttrNameValueVo> basicAttrVoMap) {
        this.basicAttrVoMap = basicAttrVoMap;
    }

    public Map<String, DeviceExtendAttrNameValueVo> getExtendAttrVoMap() {
        return extendAttrVoMap;
    }

    public void setExtendAttrVoMap(Map<String, DeviceExtendAttrNameValueVo> extendAttrVoMap) {
        this.extendAttrVoMap = extendAttrVoMap;
    }

    @Override
    public String toString() {
        return "DeviceAddParam{" +
                "deviceCommonNameAttrs=" + deviceCommonNameAttrs +
                ", basicAttrVoMap=" + basicAttrVoMap +
                ", extendAttrVoMap=" + extendAttrVoMap +
                '}';
    }
}