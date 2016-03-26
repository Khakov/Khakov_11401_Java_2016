<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 21.03.2016
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>
<form action="${path}" method="GET">
<input type="text" name="${text}">
    <input type="submit" value="search on ${search}">
</form>
</body>
</html>
