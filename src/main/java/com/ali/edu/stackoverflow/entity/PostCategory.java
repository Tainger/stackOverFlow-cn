package com.ali.edu.stackoverflow.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/7/5 22:20
 */
@Data
public class PostCategory {
    private Integer id;
    private String name;
    private Boolean status;
    private Date date;
}
