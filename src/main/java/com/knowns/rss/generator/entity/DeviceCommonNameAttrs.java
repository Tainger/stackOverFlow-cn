package com.knowns.rss.generator.entity;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 19:08
 */
public class DeviceCommonNameAttrs {
    /**
     * 设备类型名称
     */
    private String deviceTypeName;

    /**
     * 设备类型展示名称
     */
    private String deviceTypeDisplayName;

    /**
     * 制造商名称
     */
    private String manufacturerName;

    /**
     * 制造商展示名称
     */
    private String manufacturerDisplayName;

    /**
     * 设备型号
     */
    private String deviceCode;

    /**
     * 设备型号展示名称
     */
    private String deviceCodeDisplayName;

    public String getDeviceTypeName() {
        return deviceTypeName!=null ? deviceTypeName.trim() : null;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getManufacturerName() {
        return manufacturerName!=null ? manufacturerName.trim() : null;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getDeviceCode() {
        return deviceCode!=null ? deviceCode.trim() : null;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceTypeDisplayName() {
        return deviceTypeDisplayName;
    }

    public void setDeviceTypeDisplayName(String deviceTypeDisplayName) {
        this.deviceTypeDisplayName = deviceTypeDisplayName;
    }

    public String getManufacturerDisplayName() {
        return manufacturerDisplayName;
    }

    public void setManufacturerDisplayName(String manufacturerDisplayName) {
        this.manufacturerDisplayName = manufacturerDisplayName;
    }

    public String getDeviceCodeDisplayName() {
        return deviceCodeDisplayName;
    }

    public void setDeviceCodeDisplayName(String deviceCodeDisplayName) {
        this.deviceCodeDisplayName = deviceCodeDisplayName;
    }

    @Override
    public String toString() {
        return "DeviceCommonNameAttrs{" +
                "deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceTypeDisplayName='" + deviceTypeDisplayName + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerDisplayName='" + manufacturerDisplayName + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", deviceCodeDisplayName='" + deviceCodeDisplayName + '\'' +
                '}';
    }
}

