package com.ali.edu.stackoverflow.entity;

import lombok.Data;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/7/5 22:09
 */
@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String picture;
    private String content;
    private Integer shareCount;
    private String path;
    private boolean type;
    private Integer createTime;
    private Integer postCategoryId;
    private Integer shareId;
    private boolean isOpen;
}
