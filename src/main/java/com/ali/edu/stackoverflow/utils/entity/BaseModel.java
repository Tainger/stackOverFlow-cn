package com.ali.edu.stackoverflow.utils.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author rocky
 * @Description:
 * @Date: 2020-09-27
 * @Time: 22:50
 */
public class BaseModel {



    private String bmpId;


    private String id;

    private Date createTimestamp;


    private Date lastChangeTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeTimestamp() {
        return lastChangeTimestamp;
    }

    public void setLastChangeTimestamp(Date lastChangeTimestamp) {
        this.lastChangeTimestamp = lastChangeTimestamp;
    }

    public String getBmpId() {
        return bmpId;
    }

    public void setBmpId(String bmpId) {
        this.bmpId = bmpId;
    }

    /**
     * 入库前初始化,设置uuid,时间信息
     */
    public void initialize() {
        this.setId(UUIDGenerator.getUUID());
        this.setCreateTimestamp(new Date());
        this.setLastChangeTimestamp(new Date());
    }
}
