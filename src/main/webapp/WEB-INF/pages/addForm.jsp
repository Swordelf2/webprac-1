<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>

<form:form id="formCreate" modelAttribute="newClient" method="post" action="submitNew">
    Название
    <form:input path="name"/>
    Текст
    <form:input path="phone"/>
    <form:input path="email"/>
    <form:hidden path="clientId"/>
    <button type="submit">Сохранить</button>
</form:form>
<a href="list">Отмена</a>

</body>
</html>
