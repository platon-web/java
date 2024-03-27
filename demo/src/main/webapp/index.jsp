<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h2>Survey Form</h2>--%>
<%--<form action="hello-servlet" method="post">--%>
<%--    <label for="fullName">Full Name:</label><br>--%>
<%--    <input type="text" id="fullName" name="fullName" required><br>--%>

<%--    <label for="phone">Phone:</label><br>--%>
<%--    <input type="tel" id="phone" name="phone" required><br>--%>

<%--    <label for="email">Email:</label><br>--%>
<%--    <input type="email" id="email" name="email" required><br>--%>

<%--    <label for="age">Age:</label><br>--%>
<%--    <input type="number" id="age" name="age" required><br>--%>

<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>

<h2>Будь ласка, заповніть анкету</h2>
<form action="hello-servlet" method="post">
    <label for="fullName">ПІБ:</label>
    <input type="text" id="fullName" name="fullName" required><br><br>

    <label for="phone">Телефон:</label>
    <input type="text" id="phone" name="phone" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="age">Вік:</label>
    <input type="number" id="age" name="age" required><br><br>

    <label for="gender">Стать:</label>
    <select id="gender" name="gender">
        <option value="male">Чоловік</option>
        <option value="female">Жінка</option>
    </select><br><br>

    <input type="submit" value="Відправити">
</form>
</body>
</html>