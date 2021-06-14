<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post" action="create">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td align="right" width="100">Date</td> <td><input type="datetime-local" name="date" value="${meal.dateTime}"/></td>
        </tr>
        <tr>
        <td align="right" width="100">Description</td> <td><input name="description" value="${meal.description}"/></td>
        </tr>
        <tr>
            <td align="right" width="100">Calories</td> <td><input type="number" name="calories" value="${meal.calories}"/></td>
        </tr>
        <tr>
            <td align="right" width="100"><input type="number" hidden name="id" value="${meal.id}"/>
                <input type="submit" value="Создать/Обновить"/>
            <td>
        </tr>
    </table>
</form>
<form action="meals" target="_blank">
    <button>Отмена</button>
</form>
<!--     <button onclick="window.history.back()" type="button">Cancel</button> -->
</body>
</html>
