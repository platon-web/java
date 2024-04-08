<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Notebooks</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Manufacturer</th>
        <th>Notebook Name</th>
        <th>Number of Pages</th>
        <th>Cover Type</th>
        <th>Country</th>
        <th>Page Style</th>
    </tr>
    <c:forEach items="${notebooks}" var="notebook">
        <tr>
            <td>${notebook.id}</td>
            <td>${notebook.manufacturer}</td>
            <td>${notebook.notebookName}</td>
            <td>${notebook.numberOfPages}</td>
            <td>${notebook.coverType}</td>
            <td>${notebook.country}</td>
            <td>${notebook.pageStyle}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>