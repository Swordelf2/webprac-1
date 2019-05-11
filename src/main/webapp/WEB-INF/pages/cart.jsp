<%@ page import="cart.Cart" %>
<%@ page import="entity.Books" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
</head>
<body>

<h1>Добро пожаловать</h1>

<c:if test="${not empty sessionScope.cart}">Корзина (<%=((Cart) request.getSession().getAttribute("cart")).getItemMap().size()%>)</c:if>
<p>
    Найдется не всё
</p>
<form action="<c:url value="/search"/>" method="post">
    <label for="bookSearch">Поиск по книгам:</label>
    <input id="bookSearch" name="bookName" type="text" style="width: 1000px" />
    <input value="Искать" type="submit"/>
</form>
<br>
<c:if test="${not empty bookList}">
    <table border="1px">
        <tr>
            <th>Название</th>
            <th>Издательство</th>
            <th>Цена</th>
            <th>Год</th>
            <th>Кол-во страниц</th>
            <th>Переплет</th>
        </tr>
        <c:forEach items="${bookList}" var="item">
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.publishersByPublisherId.name}"/></td>
                <td><c:out value="${item.price}"/></td>
                <td><c:out value="${item.year}"/></td>
                <td><c:out value="${item.pages}"/></td>
                <td><c:out value="${item.cover}"/></td>
                <% Cart cart = (Cart) session.getAttribute("cart");
                    boolean t = cart == null|| !cart.getItemMap().containsKey(request.getAttribute("item"));
                    request.setAttribute("t", t);
                %>
                <td><c:choose>
                    <c:when test="not ${requestScope.t}">В корзине</c:when>
                    <c:otherwise>
                        <a href="<c:url value="/addToCart?id=${item.bookId}"/>">В корзину</a></c:otherwise>
                </c:choose></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value="/login" />">Войти</a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p>Ваш логин: <sec:authentication property="principal.username" /></p>
    <p><a href="<c:url value="/login?logout=true" />" role="button">Выйти</a></p>
</sec:authorize>



</body>
</html>
