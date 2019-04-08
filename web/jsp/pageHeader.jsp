<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.03.2019
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="pageHeaderDiv">

<h1>
    SDA FORUM
</h1>
<img id="picture"
     src="https://media.giphy.com/media/YPFcKRcys7bW/giphy.gif"/>
<div>
    Witaj na Forum
</div>


   <div>
       <c:if test="${sessionScope.containsKey('loggerUserId')}">
       <a href="${pageContext.request.contextPath}/LogoutAction">Wyloguj</a>
       </c:if>

   </div>


</div>
