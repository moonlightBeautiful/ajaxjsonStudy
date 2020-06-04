package com.ims.c06fastJson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author: GaoXu
 * @date: 2020/5/24
 * @desc: 请对类进行描述
 */
public class Person {

    private String name;
    private int age;
    private Date birthDay;

    public Person() {
    }

    public Person(String name, int age, Date birthDay) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                '}';
    }
}
