<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Реєстрація</title>
</head>
<body>
<h1>Реєстрація</h1>
<form action="register" method="post">
  <label for="username">Логін:</label>
  <input type="text" id="username" name="username" required><br>
  <label for="password">Пароль:</label>
  <input type="password" id="password" name="password" required><br>
  <input type="submit" value="Зареєструватися">
</form>
</body>
</html>