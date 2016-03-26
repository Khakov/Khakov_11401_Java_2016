<%--
  Created by IntelliJ IDEA.
  User: Rus
  Date: 22.03.2016
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>text</title>
</head>
<body>
"
<form action="/process" method="POST">
    <textarea rows="10" cols="45" name="text">
    </textarea><br>
    <p>посчитать количество:
        <select name="read">
            <option value="words">слов</option>
            <option value="sentences">предложений</option>
            <option value="paragraphs">абзацев</option>
            <option value="symbols">символов</option>
        </select></p>
    <input type="submit" value="посчитать">
</form>
</body>
</html>
