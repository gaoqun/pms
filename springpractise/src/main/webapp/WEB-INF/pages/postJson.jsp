<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/7/13
  Time: 下午6:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <%--import jquery--%>
    <script type="text/javascript" src="/resource/js/jquery-1.4.2.min.js"/>
    <script type="text/javascript" src="/resource/js/json2.js"/>
    <script type="text/javascript">
        $.ready(function () {
            console.log("${pageContext.request.contextPath}/hello/changeJson");
            testRequestJson();
        });

        function testRequestJson() {
            $(document).ajax({
                dataType: 'json',
                type: 'POST',
                url: "${pageContext.request.contextPath}/hello/changeJson",
                contentType: "application/json, text/javascript",
                async: true,
                data: JSON.stringify({userName: "老王", password: "0000", age: 11}),
//               成功回调方法
                success: function (callback) {
                    console.log(callback);
                    $("#userId").html(callback.userName)
                },
                error: function () {
                    alert("发送数据失败！");
                }
            });
        }

    </script>
</head>
<body>
用户信息：<h1 id="userId"></h1><br/>
</body>
</html>
