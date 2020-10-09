package com.ali.edu.stackoverflow.entity;

import lombok.Data;

@Data
public class UserBind {
    private Integer id;
    private Integer type;
    private String openid;
    private Integer userId;
    private String nickName;
    private String avatarUrl;
}
