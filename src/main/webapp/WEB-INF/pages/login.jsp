<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>

<a href="index">Главная</a><br>

<c:if test="${param.error}">
    <p style="color:red"> Некорректная пара логин-пароль </p>
</c:if>
<c:if test="${param.logout}">Вы успешно вышли!</c:if>
<div align="center">
<form method="POST" action="<c:url value="/j_spring_security_check"/>">
        <label for="username">Логин</label>
        <input id="username" type="text" name="username"/><br>
        <label for="password">Пароль</label>
        <input id="password" type="password" name="password" /><br>
        <button type="submit">Login</button>
</form>
</div>
</body>
</html>