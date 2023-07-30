package com.knowns.rss.generator.entity;

import java.util.Date;

public class People {


    private String name;

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }



    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "People{" +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
