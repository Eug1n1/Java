<%--
  Created by IntelliJ IDEA.
  User: eug1n1
  Date: 4/20/21
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrovo4ka</title>
</head>
<body>
<h1>Employee Registration Form</h1>
<form action="<%=request.getContextPath()%>/registration" method="post">
    <table style="with: 100%">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><input type="text" name="role" /></td>
        </tr>

    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
