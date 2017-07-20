<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/7/19
  Time: 下午6:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>

<form action="/login" method="post">
    <table style="text-align: center">
        <tr style="text-align: center">
            <td><label>用户名</label></td>
            <td><input type="text" name="loginname" id="loginname"></td>
        </tr>
        <br/>
        <tr>
            <td><label>密码</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <br/>
        <tr>
            <td><button type="commit" id="commit">提交</button></td>
        </tr>
        <br/>
    </table>
</form>

</body>
</html>
