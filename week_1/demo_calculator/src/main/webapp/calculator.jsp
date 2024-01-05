<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <input type="hidden" name="action" value="calculatorPage">
    <table>
        <tr>
            <th>First:</th>
            <td><input type="text" name="num1"></td>
        </tr>
        <tr>
            <th>Second:</th>
            <td><input type="text" name="num2"></td>
        </tr>
        <tr>
            <th>Operator</th>
            <td>
                <select name="operator" id="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="submit"></td>
        </tr>

        <tr>
            <th>Result</th>
            <td><%=request.getAttribute("result")%></td>
        </tr>
    </table>
</form>
</body>
</html>