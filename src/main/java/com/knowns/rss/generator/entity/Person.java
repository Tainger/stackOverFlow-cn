package com.knowns.rss.generator.entity;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/8/4 16:09
 */
public class Person {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
