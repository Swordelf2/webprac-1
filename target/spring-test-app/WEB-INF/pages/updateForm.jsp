<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Добавьте свою идею!</title>
</head>
<body>

<form:form id="formCreate" modelAttribute="newClient" method="post" action="submitUpdate">
    Название
    <form:input path="name"/>
    Текст
    <form:input path="phone"/>
    <form:input path="email"/>
    <form:password path="password"/>
    <button type="submit">Сохранить</button>
</form:form>
<span><a href="list">Отмена</a></span>
<span><a href="delete?id=${newClient.clientId}">Удалить</a></span>

</body>
</html>
