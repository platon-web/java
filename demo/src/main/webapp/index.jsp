<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Survey Form</h2>
<form action="SurveyServlet" method="post">
    <label for="fullName">Full Name:</label><br>
    <input type="text" id="fullName" name="fullName" required><br>

    <label for="phone">Phone:</label><br>
    <input type="tel" id="phone" name="phone" required><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br>

    <label for="age">Age:</label><br>
    <input type="number" id="age" name="age" required><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>