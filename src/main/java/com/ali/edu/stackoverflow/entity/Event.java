package com.ali.edu.stackoverflow.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Event {

    /**
     * 事件的一个主题
     */
    private String topic;

    /**
     * 谁出发了事件
     */
    private int userId;

    /**
     * 参与事件的实体类型
     */
    private int entityType;

    /**
     *  参与事件的实体的id
     */
    private int entityId;

    /**
     * 参与事件的实体UserId
     */
    private int entityUserId;

    /**
     * 携带额外的数据
     */
    private Map<String,Object> data = new HashMap();

}
