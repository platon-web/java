<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Налаштування теми</title>
</head>
<body>
<h1>Налаштування теми</h1>
<form action="theme_settings" method="post">
    <label for="theme">Оберіть тему:</label>
    <select id="theme" name="theme">
        <option value="Стандартна тема">Стандартна тема</option>
        <option value="Новорічна тема">Новорічна тема</option>
        <option value="Тема Хелловін">Тема Хелловін</option>
        <option value="Літня тема">Літня тема</option>
    </select>
    <input type="submit" value="Зберегти">
</form>
</body>
</html>