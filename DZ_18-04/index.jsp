<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Квіз</title>
</head>
<body>
<h1>Квіз</h1>
<div id="timer">Час: <%= request.getAttribute("timeLimit") %></div>
<form id="quizForm" action="quiz" method="post">
    <input type="hidden" name="currentIndex" value="<%= request.getAttribute("currentIndex") %>">
</form>

<%
    if (request.getMethod().equals("GET") && request.getParameter("result") != null) {
        int correctAnswers = Integer.parseInt(request.getParameter("correctAnswers"));
        int incorrectAnswers = Integer.parseInt(request.getParameter("totalQuestions")) - correctAnswers;
        double totalTime = Double.parseDouble(request.getParameter("totalTime"));
        double averageTimePerQuestion = totalTime / Integer.parseInt(request.getParameter("totalQuestions"));

        out.println("<h2>Результати квізу</h2>");
        out.println("<p>Правильних відповідей: " + correctAnswers + "</p>");
        out.println("<p>Неправильних відповідей: " + incorrectAnswers + "</p>");

        out.println("<h3>Відповіді на питання:</h3>");
        out.println("<p>Питання 1: Правильна відповідь - Правильна, Ваша відповідь - Правильна</p>");

        out.println("<p>Загальна кількість часу: " + totalTime + " секунд</p>");
        out.println("<p>Середня кількість часу на питання: " + averageTimePerQuestion + " секунд</p>");
    }
%>
</body>
</html>