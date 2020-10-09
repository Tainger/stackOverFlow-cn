package com.ali.edu.stackoverflow.zdemo;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-23
 * @Time: 15:36
 */
public class MeasureFactor {

    private String factorCategory;

    /**
     * 因子编码
     */
    private String factorCode;

    /**
     * 因子名称
     */
    private String factorName;

    public String getFactorCategory() {
        return factorCategory;
    }

    public void setFactorCategory(String factorCategory) {
        this.factorCategory = factorCategory;
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    @Override
    public String toString() {
        return "MeasureFactor{" +
                "factorCategory='" + factorCategory + '\'' +
                ", factorCode='" + factorCode + '\'' +
                ", factorName='" + factorName + '\'' +
                '}';
    }
}
