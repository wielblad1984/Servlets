<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.03.2019
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file="../css/login.css"%>
    </style>
</head>
<body>
<%@include file="pageHeader.jsp"%>



<div id="loginFormDiv">

    <div>
        LOGOWANIE
    </div>
   <form method="post" action="LoginAction">
       <input name="login" type="text">
       <br>
       <input name="password" type="password">
       <br>
       <input name="submit" type="submit">
   </form>
</div>

<%@include file="pageFooter.jsp"%>

</body>
</html>
