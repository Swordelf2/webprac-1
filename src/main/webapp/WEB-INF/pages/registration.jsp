<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>

<h2 align="center">Регистрация</h2>

<div align="center">
    <c:if test="${invalid}"><p style="color:red">Пользователь с таким email уже существует</p></c:if>
    <form:form modelAttribute="newUser" method="post" action="submitNew">
        <table align="center">
            <tr>
                <td>ФИО</td><td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Телефон</td><td><form:input path="phone"/></td>
            </tr>
            <tr>
                <td>Email</td><td><form:input path="email"/></td>
            </tr>
            <tr>
                <td>Password</td><td><form:input type="password" path="password"/></td>
            </tr>
        </table>

        <button type="submit">Зарегистрироваться</button>
    </form:form>
</div>

</body>
</html>
