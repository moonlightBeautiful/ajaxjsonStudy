ajax&json
AJAX简介：
    AJAX（Asynchronous Javascript And XML）是一种交互式的网页开发技术，可以使网页实现异步(局部)更新。
Ajax与传统交互比较：
    传统交互：必须重载整个网页页面。服务器压力大。用户体验不好。
    AJAX交互：网页可以局部刷新。服务区压力小。用户体验好。
XMLHttpRequest
    简介
        Ajax核心对象，用来与后台异步交互。   
    属性和方法
        方法：open规定请求你、send发射请求   
        属性：onreadystatechange请求进度监督函数、只要readyStatereadyState或者status改变，则就触发此函数
            readyStatereadyState：XMLHttpRequest对象的状态 0-4
            status：表示响应的HTTP状态码
            responseText：响应的内容
    用法
        1.创建    XMLHttpRequest对象
        2.规定请求   xmlHttp.open("get/post", "get的url后面+参数?name=jack&age=11/post发射时+参数", true);
        3.发射请求     xmlHttp.send(post的话带参数); 
        4.监督执行状态  xmlHttp.onreadystatechange =function () {
                              if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                                  alert(xmlHttp.responseText);
                              }
                          }
    示例
        前台
            <script type="text/javascript">
                function 名字(){
                    //Step1 XMLHttpRequest对象创建  ，Microsoft.XMLHTTP 是ie5 6 的对象，老版本。
                    var xmlHttp;
                    if (window.XMLHttpRequest) {
                        xmlHttp = new XMLHttpRequest();   
                    } else {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }   
                    //Step2 请求后台  
                    xmlHttp.open("get", "/ajaxRequest?name=jack&age=11", true);  //规定请求   
                    //规定请求的类型（post和get两种，post发生数据量无限制且安全）、
                    //规定请求的地址（get的话，发送数据放在地址后面。pos的话，sent(json String)）、
                    //规定请求的是否异步（true或者false）：true 程序可以一边运行一边处理请求 false只有处理完请求程序才能运行
                    xmlHttp.send(); // 发射请求
                    //Step3 响应后台 
                    xmlHttp.onreadystatechange = function () {
                        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                            alert(xmlHttp.responseText);
                        }
                    }
                    //onreadystatechange：readyState改变时，会触发onreadystatechange
                    //readyState：XMLHttpRequest对象的状态 0-4 
                        0 请求未初始化：已经创建了一个XMLHttpRequest对象
                        1 准备发送请求：经调用了open方法，已经准备好将一个请求发送到服务器端
                        2 请求已经发送：已经通过send方法把一个请求发送到服务器端，但是还没有收到一个响应
                        3 正在接收响应中：已经接收到HTTP响应头部信息，但是消息体部分还没有完全接收到
                        4 接收完响应：已经完成了HTTP响应的接收
                    //status: 表示响应的HTTP状态码
                        200：表示请求所希望的响应头或数据体成功响应返回。
                        404：客户端请求的资源不存在。
                        500：表示服务器端运行错误，导致了它无法完成响应。此时readSate==4 也会成立。
                    //responseText:字符串形式的响应数据
                    //responseXML:XML形式的响应数据
                 }
            </script>
        后台
            out.println("ajax请求返回的文本");
            out.flush();
            out.close();
Json
    简介
        一种数据描述格式，轻量级。规则就是 {键值对} JavaScript object notation，js对象表示法。
    用法：可嵌套
        json对象
            {"name":"you","age":11}
        json数组
            [
                {"name":"you","age":11},
                {"name":"you","age":11}
            ]
    后台拼接json对象
        String str = "{\"name\":\"you\",\"age\":\"11\"}";
    前台把json字符串转成json对象
        var j = eval(""+ data +"");  
后台使用第三方jar包jsonLib拼接Json串
    pom引入需要的jar包
         <dependency>
            <groupId>net.sf.json-lib</groupId>
            <artifactId>json-lib</artifactId>
            <classifier>jdk15</classifier>
            <version>2.3</version>
        </dependency>
    使用的就是2个类 JSONObject和JSONArray
    后台
        JSONObject resultJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        out.println(resultJson);
        out.flush();
        out.close();
    前台
        var dataObj = eval("(" + xmlHttp.responseText + ")");
    
    