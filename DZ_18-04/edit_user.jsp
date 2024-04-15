<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Редагувати дані користувача</title>
</head>
<body>
<h1>Редагувати дані користувача</h1>
<%-- Вивести список користувачів та дозволити вибрати одного для редагування --%>
<form action="edit_user" method="post">
    <%-- Виведення списку користувачів для вибору --%>
    <label for="newUsername">Новий логін:</label>
    <input type="text" id="newUsername" name="newUsername" required><br>
    <label for="newPassword">Новий пароль:</label>
    <input type="password" id="newPassword" name="newPassword" required><br>
    <input type="submit" value="Зберегти зміни">
</form>
</body>
</html>