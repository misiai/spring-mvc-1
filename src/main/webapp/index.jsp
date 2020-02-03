<%--
  Created by IntelliJ IDEA.
  User: Kuan
  Date: 2020/2/3
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Hello World!</h2>

<p>
    <a href="${pageContext.request.contextPath}/lang/test?lang=zh_CN">中文</a>
    <a href="${pageContext.request.contextPath}/lang/test?lang=en_US">英文</a>
</p>
<hr>
<br><br>

<form action="${pageContext.request.contextPath}/upload/test" method="post" enctype="multipart/form-data">
    File:<input type="file" name="source"><br>
    <input type="submit" value="提交">
</form>

<br><br>

<form action="test/testDomainParam" method="post">
    <input type="text" name="username" value="kuan">
    <input type="text" name="age" value="18">
    <input type="submit" value="Submit">
</form>

<form action="test/testRestful" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Submit">
</form>

<br><br>
<form action="test/testMethod" method="post">
    <input type="submit" value="Submit">
</form>

<br><br>

</body>
</html>
