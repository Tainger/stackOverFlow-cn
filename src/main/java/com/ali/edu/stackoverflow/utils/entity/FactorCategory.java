package com.ali.edu.stackoverflow.utils.entity;

import javax.persistence.Column;
import javax.persistence.Transient;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-27
 * @Time: 22:53
 */
public class FactorCategory extends BaseModel{

    private String name;

    private String code;

    private Integer pos;

    private String posCode;

    private Integer editFlag;

    private FactorCategory parent;

    private String parentId;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public Integer getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(Integer editFlag) {
        this.editFlag = editFlag;
    }

    public FactorCategory getParent() {
        return parent;
    }

    public void setParent(FactorCategory parent) {
        this.parent = parent;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FactorCategory{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", pos=" + pos +
                ", posCode='" + posCode + '\'' +
                ", editFlag=" + editFlag +
                ", parent=" + parent +
                ", parentId='" + parentId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
