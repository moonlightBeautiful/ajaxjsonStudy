package com.ims.c06fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @author: GaoXu
 * @date: 2020/6/4 23:15
 * @Description: (用一句话描述该文件做什么)
 */
public class App {

    public static void main(String[] args) {
        //1.创建 JSON 对象 JSONObject 和 JSONArray
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AGE", 10);
            jsonObject.put("FULL NAME", "Doe " + i);
            jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");
            System.out.println("json对象：" + jsonObject.toJSONString());
            jsonArray.add(jsonObject);
        }
        System.out.println("json数组：" + jsonArray.toJSONString());

        //2.Java对象 转换为 JSON字符串
        Person person = new Person("John", 20, new Date());
        System.out.println("java对象 转换为 JSON字符串：" + JSON.toJSONString(person));
        //3.JSON字符串 转换为 Java对象
        Person newPerson = JSON.parseObject(JSON.toJSONString(person), Person.class);
        System.out.println("JSON字符串 转换为 java对象：" + newPerson);

    }
}
