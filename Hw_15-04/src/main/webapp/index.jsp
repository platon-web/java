<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Current Time and Date</h1>

<p>Current Date and Time: <%
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd, yyyy HH:mm:ss z");
    out.print(formatter.format(date));
%></p>

</body>
</html>