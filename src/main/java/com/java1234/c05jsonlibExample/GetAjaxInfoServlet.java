package com.java1234.c05jsonlibExample;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetAjaxInfoServlet extends HttpServlet {

    /**
     *
     */
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
        if ("checkUserName".equals(action)) {
            this.checkUserName(request, response);
        } else if ("ejld".equals(action)) {
            this.ejld(request, response);
        }

    }


    private void checkUserName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        JSONObject resultJson = new JSONObject();
        if ("jack".equals(userName)) {
            resultJson.put("exist", true);
        } else {
            resultJson.put("exist", false);
        }
        //{"exist", boolean}
        out.println(resultJson);
        out.flush();
        out.close();
    }

    private void ejld(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String shengId = request.getParameter("shengId");
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject temp = null;
        //[{"id":1,"text":"南京"},{"id":1,"text":"南京"},{"id":1,"text":"南京"}]
        switch (Integer.parseInt(shengId)) {
            case 1: {
                temp = new JSONObject();
                temp.put("id", 1);
                temp.put("text", "南京");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 2);
                temp.put("text", "南通");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 3);
                temp.put("text", "泰兴");
                jsonArray.add(temp);
                break;
            }
            case 2: {
                temp = new JSONObject();
                temp.put("id", 4);
                temp.put("text", "济南");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 5);
                temp.put("text", "烟台");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 6);
                temp.put("text", "蓬莱");
                jsonArray.add(temp);
                break;
            }
            case 3: {
                temp = new JSONObject();
                temp.put("id", 7);
                temp.put("text", "杭州");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 8);
                temp.put("text", "宁波");
                jsonArray.add(temp);
                temp = new JSONObject();
                temp.put("id", 9);
                temp.put("text", "温州");
                jsonArray.add(temp);
                break;
            }
        }
        //  {"rows":[{"id":1,"text":"南京"},{"id":1,"text":"南京"},{"id":1,"text":"南京"}]}
        resultJson.put("rows", jsonArray);
        out.println(resultJson);
        out.flush();
        out.close();
    }

}
