<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.04.2019
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSTL</title>
</head>
<body>

<h1>WELCOME JSTL!!</h1>

<c:out value="SIEMANKO"/>
<br>

<jsp:useBean id="SimpleBean" class="demoJsp.SimpleBean"/>
<jsp:setProperty name="SimpleBean" property="name" value="Krycha"/>
<c:out value="${SimpleBean.name}" default="Nie ma imienia"/>
<br>
<c:set var="licznik" value="Jestem licznikiem ustawionym na zero"/>
<c:out value="${licznik}"/>
<br>

<h1>TUTORIAL c:set
<c:set target="${SimpleBean}" property="name" value="Zbychu"/>
    <c:out value="${SimpleBean.name}"/>
</h1>
<c:if test="${SimpleBean.name.contains('Zby')}">
    <div>Czyzby to był Zbychu</div>
</c:if>

<c:choose>
    <c:when test="${SimpleBean.name.startsWith('Zb')}">
        <div>Zbychu to znowu TY:)</div>

    </c:when>
    <c:otherwise>
        <div>Nie rozpoznano imienia:(</div>

    </c:otherwise>
</c:choose>

<c:forEach items="${SimpleBean.words}" var="word">
    <c:out value="${word}"/>

</c:forEach>
<br>

<c:forTokens items="a, kot ma Ale" delims="," var="word">
    <c:out value="${word}"/>
</c:forTokens>

<h1>C:CATCH</h1>

<c:catch var="catchTheException">
    <% int x=2/0;%>
</c:catch>

<c:if test="${catchTheException !=null}">
    <p>The type of exception is : ${catchTheException}<br>
    There is an exception : ${catchTheException.message}
    </p>
</c:if>



</body>
</html>




