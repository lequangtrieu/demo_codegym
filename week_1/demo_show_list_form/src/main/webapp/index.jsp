<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Using Form</h1>
<form name="myForm" action="demo" method="POST">
    <table border="0">
        <tbody>
        <tr>
            <td> First Name:</td>
            <td><input type="text" name="fName" value="" size="50"/></td>
        </tr>
        <tr>
            <td> Last Name:</td>
            <td><input type="text" name="lName" value="" size="50"/></td>
        </tr>
        <tr>
            <td> Email Address:</td>
            <td><input type="text" name="email" value="" size="50"/></td>
        </tr>
        <tr>
            <td> Gender:</td>
            <td><select name="gender">
                <option>Male</option>
                <option>Female</option>
            </select></td>
        </tr>
        <tr>
            <td> Date of Birth:</td>
            <td><input type="text" name="birth" value="MM/DD/YYYY" size="15"/></td>
        </tr>
        </tbody>
    </table>
    <input type="reset" value="Clear" name="bntClear"/>
    <input type="submit" value="Submit" name="btnSubmit"/>
</form>
</body>
</html>