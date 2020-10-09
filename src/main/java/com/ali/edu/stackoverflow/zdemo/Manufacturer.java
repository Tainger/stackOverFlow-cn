package com.ali.edu.stackoverflow.zdemo;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-27
 * @Time: 17:31
 */
public class Manufacturer {

    private String manufacturerName;
    /**
     * 制造商编码
     */

    private String manufacturerCode;

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerCode='" + manufacturerCode + '\'' +
                '}';
    }
}
