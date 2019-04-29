<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2>Список пользователей:</h2>
<a href="create">Регистрация</a>
<table border="2px">
    <tr>
        <th>Id</th>
        <th>ФИО</th>
        <th>Телефон</th>
        <th>Email</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value="${item.clientId}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.phone}"/></td>
            <td><c:out value="${item.email}"/></td>
            <td>
                <span><a href="update?id=${item.clientId}">edit</a></span>
                <span><a href="delete?id=${item.clientId}">delete</a></span>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
