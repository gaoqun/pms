<%--
  Created by IntelliJ IDEA.
  User: gaige
  Date: 2017/7/13
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body style="text-align: center">
<h2>登录界面</h2>
<form action="/user/login" method="post">
    <table>
        <tr style="text-align: center">
            <td>
                用户名：
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr style="text-align: center">
            <td>
                密码：
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr style="text-align: center">
            <td>
                <button type="submit" name="login">登录</button>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
