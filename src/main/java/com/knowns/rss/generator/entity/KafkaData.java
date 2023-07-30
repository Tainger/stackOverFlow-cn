package com.knowns.rss.generator.entity;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaData {

    private Long id;
    private String msg;
    private Date sendTime;

}
