package com.ali.edu.stackoverflow.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String userName;
    private String headerUrl;
    private String password;
    private String phone;
    private String email;
    private Boolean status;
    private Date createTime;
}
