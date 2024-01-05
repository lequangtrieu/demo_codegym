<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/11/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>

<h1 style="text-align: center">Login to the FPT System</h1>
<%
    String err = request.getParameter("err");

    if ("1".equals(err)) {
        out.print("<h4 style=\"color: red;\">Login Fail, please enter the correct username and password</h4>");
    }
%>

<form name="myForm" action="/login" method="POST">
    <input type="hidden" name="action" value="doLogin">
    <table border="0">

        <tbody>
        <tr>
            <td>User Name:</td>
            <td><input type="text" name="username" value="" size="50"/></td>

        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" value="" size="50"/></td>

        </tr>


        </tbody>
    </table>
    <hr>

    <input type="submit" value="Login" name="submit"/>

</form>

</body>
</html>
