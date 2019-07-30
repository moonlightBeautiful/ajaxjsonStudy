package com.java1234.c04jsonlib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class GetAjaxInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("jsonObject".equals(action)) {
            this.getJsonObject(request, response);
        } else if ("jsonArray".equals(action)) {
            this.getJsonArray(request, response);
        } else if ("jsonNested".equals(action)) {
            this.getJsonNested(request, response);
        }

    }


    private void getJsonObject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject resultJson = new JSONObject();
        // {name:"张三",age:"22"}
        resultJson.put("name", "张三");
        resultJson.put("age", 22);
        out.println(resultJson);
        out.flush();
        out.close();
    }

    private void getJsonArray(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        // {name:"张三",age:"22"}
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "李四");
        jsonObject1.put("age", 22);
        // {name:"王五",age:"23"}
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "王五");
        jsonObject2.put("age", 23);
        // {name:"赵六",age:"24"}
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("name", "赵六");
        jsonObject3.put("age", 24);
        // [
        //      {name:"张三",age:"22"},
        //      {name:"王五",age:"23"},
        //      {name:"赵六",age:"24"}
        // ]
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);
        // {"students":
        //    [
        //      {name:"张三",age:"22"},
        //      {name:"王五",age:"23"},
        //      {name:"赵六",age:"24"}
        //    ]
        // }
        resultJson.put("students", jsonArray);
        out.println(resultJson);
        out.flush();
        out.close();
    }

    private void getJsonNested(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // {name:"张三",age:"22",score:{"chinese":90,"math":100,english":80}}
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "张三");
        jsonObject1.put("age", 22);
        JSONObject scoreObject1 = new JSONObject();
        scoreObject1.put("chinese", 90);
        scoreObject1.put("math", 100);
        scoreObject1.put("english", 80);
        jsonObject1.put("score", scoreObject1);
        // {name:"李四",age:"23",score:{"chinese":70,"math":90,english":90}}
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "李四");
        jsonObject2.put("age", 23);
        JSONObject scoreObject2 = new JSONObject();
        scoreObject2.put("chinese", 70);
        scoreObject2.put("math", 90);
        scoreObject2.put("english", 90);
        jsonObject2.put("score", scoreObject2);
        // {name:"王五",age:"24",score:{"chinese":80,"math":60,english":90}}
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("name", "王五");
        jsonObject3.put("age", 24);
        JSONObject scoreObject3 = new JSONObject();
        scoreObject3.put("chinese", 80);
        scoreObject3.put("math", 60);
        scoreObject3.put("english", 90);
        jsonObject3.put("score", scoreObject3);
        // [{name:"张三",age:"22",score:{"chinese":90,"math":100,english":80}},
        //  {name:"李四",age:"23",score:{"chinese":70,"math":90,english":90}},
        //  {name:"王五",age:"24",score:{"chinese":80,"math":60,english":90}]
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);
        // {"students":[
        //      {name:"张三",age:"22",score:{"chinese":90,"math":100,english":80}},
        //      {name:"李四",age:"23",score:{"chinese":70,"math":90,english":90}},
        //      {name:"王五",age:"24",score:{"chinese":80,"math":60,english":90}
        //    ]}
        resultJson.put("students", jsonArray);
        out.println(resultJson);
        out.flush();
        out.close();
    }
}
