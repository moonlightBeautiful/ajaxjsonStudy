package com.ims.c06jsckson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * @author: GaoXu
 * @date: 2020/6/9 21:52
 * @Description: (用一句话描述该文件做什么)
 */
public class App {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * 序列化：将java对象序列化成json串
         */
        /*
            1.bean转json串
        */
        Student student = new Student();
        student.setAge(10);
        student.setName("name");
        student.setProfileImageUrl("头像");
        //System.out.println(objectMapper.writeValueAsString(student));
        //System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student));  //格式化json串

        /*
            2.List<bean>转json串
        */
        Student student1 = new Student();
        student1.setAge(10);
        student1.setName("name1");
        student1.setProfileImageUrl("link1");
        Student student2 = new Student();
        student2.setAge(20);
        student2.setName("name2");
        student2.setProfileImageUrl("link2");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        //System.out.println(objectMapper.writeValueAsString(studentList));
        //System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentList));  //格式化json串

        /*
            3.其他类型转json串，举例map
         */
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("a", Arrays.asList(1, 2, 3));
        map.put("b", Arrays.asList(1, 2, 3));
        //System.out.println(objectMapper.writeValueAsString(map));
        //System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));  //格式化json串

        /**
         * 反序列化：将json转为java对象
         */
        /*
            1.json串转bean
         */
        String str = "{\"name\":\"name\",\"age\":10,\"profileImageUrl\":\"link\"}";
        //System.out.println(objectMapper.readValue(str, Student.class));

        /*
            2.json串转List<bean>
         */
        String str2 = "[{\"name\":\"name1\",\"age\":10,\"profileImageUrl\":\"link1\"},{\"name\":\"name2\",\"age\":20,\"profileImageUrl\":\"link2\"}]";
        //System.out.println(objectMapper.readValue(str2, List.class));

         /*
            3.json串转Map
         */
        String str3 = "{\"1\":[1,2,3],\"2\":[2,3,4]}";
        Map<String, List<Integer>> map1 = objectMapper.readValue(str3, Map.class);
        System.out.println(map1);


    }
}
