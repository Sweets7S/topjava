<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table border="1" bordercolor="blue" cellspacing="0" cellpadding="7">
    <thead>
    <tr align="center">
        <td><a>Date</a></td>
        <td><a>Description</a></td>
        <td><a>Calories</a></td>
        <td><a>Update</a></td>
        <td><a>Delete</a></td>
    </tr>
    </thead>
    <tbody>
<c:forEach var="meal" items="${meals}">
    <c:set value="${meal.dateTime}" var="dateString"/>
    <fmt:parseDate value="${dateString}" var="dateObject" pattern="yyyy-MM-dd'T'HH:mm" />
    <tr style="color: ${meal.excess ? 'red' : 'green'}">
        <td> <a><fmt:formatDate value="${dateObject}" pattern="yyyy-MM-dd HH:mm" /></a> </td>
        <td> <a><c:out value="${meal.description}"/></a> </td>
        <td> <a><c:out value="${meal.calories}"/></a> </td>
        <td> <a>Update</a> </td>
        <td> <form method="post" action="delete">
            <label>
            <input type="number" hidden name="id" value="${meal.id}"/>
            <input type="submit" name="delete" value="Удалить"/>
            </label>
        </form> </td>
    </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
