<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h4>Hello, This Success Page!</h4>

<%--Time：${requestScope.time}--%>

Names: ${requestScope.name}

<br><br>

Request user ${requestScope.user}

<br><br>
Session user ${sessionScope.user}
<br><br>

Request Misiai ${requestScope.Misiai}

<br><br>
Session Misiai ${sessionScope.Misiai}
</body>
</html>
