<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function loadInfo() {
            var xmlHttp;
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttp.open("get", "/getAjaxJsonInfo?name=张三&age=22", true);
            xmlHttp.send();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    alert(xmlHttp.responseText);
                    var dataObj = eval("(" + xmlHttp.responseText + ")");
                    alert(dataObj.name);
                    alert(dataObj.age);
                    document.getElementById("name").value = dataObj.name;
                    document.getElementById("age").value = dataObj.age;
                }
            };
        }
    </script>
</head>
<body>
<div style="text-align: center;">
    <div>
        <input type="button" onclick="loadInfo()" value="Ajax获取信息"/>
        &nbsp;&nbsp;姓名：<input type="text" id="name" name="name"/>
        &nbsp;&nbsp;年龄：<input type="text" id="age" name="age"/></div>
</div>
</body>
</html>