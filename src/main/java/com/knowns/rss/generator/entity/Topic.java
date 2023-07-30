package com.knowns.rss.generator.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/7/5 21:54
 */


@Data
public class Topic {
    private int id;
    private String name;
    private String picture;
    private String desc;
    /**
     * 0禁用， 1启用
     */
    private boolean type;
    private Date createTime;
    private int topicCategoryId;
}
