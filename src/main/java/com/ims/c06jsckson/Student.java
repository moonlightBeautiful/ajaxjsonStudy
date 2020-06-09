package com.ims.c06jsckson;

/**
 * @author: GaoXu
 * @date: 2020/6/9 21:51
 * @Description: (用一句话描述该文件做什么)
 */
public class Student {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 头像
     */
    private String profileImageUrl;

    public Student() {
    }

    public Student(String name, Integer age, String profileImageUrl) {
        this.name = name;
        this.age = age;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }
}
