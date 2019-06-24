ajax&json的学
    AJAX（Asynchronous Javascript And XML）是一种交互式的网页开发技术，可以使网页实现异步(局部)更新。
1.Ajax与传统交互比较：
    传统交互：必须重载整个网页页面。服务器压力大。用户体验不好。
      实现：前台使用form表单直接提交到后台，后台使用request.getRequestDispatcher("要刷新的页").forward（request,response）重新加载整个网页。
    AJAX交互：网页可以局部刷新。服务区压力小。用户体验好。
      实现：前台使用JavaScript和XMLHTTPRequest对象提交到后台，后台使用PrintWriter对象输出局部更新部分网页需要的数据。
2.Ajax核心对象：XMLHTTPRequest
    <script type="text/javascript">
        function 名字(){
            XMLHttpRequest对象创建       //Step1
            准备请求   //Step2
            发射请求   //Step3
            接收响应    //Step4
         }
    </script>
 3.字符串拼接式Json
    String str = "{\"name\":\"you\",\"age\":\"11\"}";
 4.jsonlib式Json
    JSONObject和jsonArray
    