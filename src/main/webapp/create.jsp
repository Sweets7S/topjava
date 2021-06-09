<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post" action="create">
    <label>
        Date: <input type="datetime-local" name="date" value="${meal.dateTime}"/>
        <br/>
        Description: <input name="description" value="${meal.description}"/>
        <br/>
        Calories: <input type="number" name="calories" value="${meal.calories}"/>
        <br>
        <input type="number" hidden name="id" value="${meal.id}"/>
        <input type="submit" value="Создать"/>
    </label>
</form>
</body>
</html>
