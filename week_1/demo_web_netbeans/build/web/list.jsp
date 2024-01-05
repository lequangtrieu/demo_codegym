<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/11/2023
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List</h1>
<h1>
    <%
        String fName = request.getParameter("fName");
        String lNAme = request.getParameter("lName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
    %>

    <table border="1">

        <tbody>
        <tr>
            <td>First Name:</td>
            <td><%= fName %>
            </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><%= lNAme %>
            </td>
        </tr>
        <tr>
            <td>Email Address:</td>
            <td><%= email %>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><%= gender %>
            </td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><%= birth %>
            </td>
        </tr>
        </tbody>
    </table>
</h1>
</body>
</html>
