<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student detail</title>
</head>
<body>
    <h1>Student detail</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>${student.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${student.name}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${student.age}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${student.address}</td>
        </tr>
        <tr>
            <td>Hobbies</td>
            <td>
                <c:forEach items="${student.hobbies}" var="item">
                    ${item}&nbsp;&nbsp;&nbsp;&nbsp;
                </c:forEach>
            </td>
        </tr>
    </table>
</body>
</html>
