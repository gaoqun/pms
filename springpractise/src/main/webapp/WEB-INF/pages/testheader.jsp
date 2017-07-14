<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/7/13
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>test request header</title>
</head>
<body>
<h2 style="text-align: center">test request header</h2>
<br/><br/>
<a href="/hello/pathvar/1">pathVar</a>
<br/><br/>
<a href="/hello/agent">注解2headerRequest</a>
<br/><br/>
<a href="/hello/cookie">注解3JSESSIONID</a>
<br/><br/>
</body>
</html>
