<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <h1>Create student</h1>
    <form:form action="/student/create" method="post" modelAttribute="student" cssClass="">
        <table border="1">
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><form:input path="address" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>Hobbies</td>
                <td>
                    <%--<form:checkboxes path="hobbies" items="${itemsHobbies}" />--%>
<%--                    <form:radiobuttons path="hobbies" items="${itemsHobbies}" />--%>
                    <form:select path="hobbies" items="${itemsHobbies}" />
                </td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
