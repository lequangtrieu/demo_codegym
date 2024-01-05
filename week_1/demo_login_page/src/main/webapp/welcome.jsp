<%@ page import="com.example.demo_login_page.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/11/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome Page</h1>
<h2>Welcome: <%=request.getAttribute("user")%></h2>
</body>
</html>
