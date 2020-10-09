package com.ali.edu.stackoverflow.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/7/5 22:22
 */

@Data
public class PostImage {
    private Integer id;
    private Integer postId;
    private Integer imageId;
    private Date  createTime;
}
