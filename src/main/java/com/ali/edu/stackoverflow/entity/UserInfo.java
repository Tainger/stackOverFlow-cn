package com.ali.edu.stackoverflow.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private Integer userId;
    private Integer age;
    private boolean sex;
    private boolean relationStatus;
    private String job;
    private String hometown;
    private Date  birthday;
}
