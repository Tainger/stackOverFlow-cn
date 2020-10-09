package com.ali.edu.stackoverflow.entity;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 19:09
 */

import java.util.List;
import java.util.Map;

public class DeviceExtendAttrNameValueVo {

    /**
     * 设备属性展示名称
     */
    private String extendAttrDisplayName;

    /**
     * 设备属性值
     */
    private List<Map<String, DeviceSubAttrNameValueVo>> extendAttrValuesMapList;

    public String getExtendAttrDisplayName() {
        return extendAttrDisplayName;
    }

    public void setExtendAttrDisplayName(String extendAttrDisplayName) {
        this.extendAttrDisplayName = extendAttrDisplayName;
    }

    public List<Map<String, DeviceSubAttrNameValueVo>> getExtendAttrValuesMapList() {
        return extendAttrValuesMapList;
    }

    public void setExtendAttrValuesMapList(List<Map<String, DeviceSubAttrNameValueVo>> extendAttrValuesMapList) {
        this.extendAttrValuesMapList = extendAttrValuesMapList;
    }

    @Override
    public String toString() {
        return "DeviceExtendAttrNameValueVo{" +
                "extendAttrDisplayName='" + extendAttrDisplayName + '\'' +
                ", extendAttrValuesMapList=" + extendAttrValuesMapList +
                '}';
    }
}
