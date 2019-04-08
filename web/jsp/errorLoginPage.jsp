<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.03.2019
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login error</title>
    <style>
        <%@include file="../css/login.css"%>
    </style>
</head>
<body>

<%
    response.setStatus(401);
%>
<%@include file="pageHeader.jsp"%>

<div style="font-size: 30px;color: red;">
    Niepoprawny Login lub Hasło

</div>
WPISZ POPRAWNY LOGIN I HASŁO
<br>
<a href="login.jsp">LOGIN</a>



<%@include file="pageFooter.jsp"%>

</body>
</html>
