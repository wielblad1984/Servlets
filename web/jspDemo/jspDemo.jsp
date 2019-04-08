<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 30.03.2019
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <style><%@include file="../css/exercises.css"%></style>
</head>
<body>
<div id="header-div">



    <h1>
   SCRYPTLET
    </h1>
    <p>
        <%
            for (int i = 0; i <10 ; i++) {
              out.println(i);

            }

        %>
    </p>

    <table style="border: 2px solid crimson">
        <thead>
        <tr>
            <td>Imie</td>
            <td>Nazwisko</td>
        </tr>

        </thead>
        <tbody>

        <tr>
            <td>Janusz</td>
            <td>Januszewski</td>
        </tr>
        <tr>
            <td>Krystyna</td>
            <td>Kopacinska</td>
        </tr>
        <%
            for (int i = 0; i < 4; i++) {
                out.print("<tr><td>"+ i +"</td><td>" + i * i+"</td></tr>");
            }
        %>

        <h1>
           LICZBA WYSWIETLEŃ
        </h1>



        <%! private int visitCount=0;%>

        Liczaba wyświetleń: <%=visitCount%> <br>

        <% visitCount++;%>

        <%
            String liczba1= request.getParameter("liczba1");
            String liczba2= request.getParameter("liczba2");


            if (liczba1!=null&&liczba2!=null) {
                int first = Integer.parseInt(liczba1);
                int second = Integer.parseInt(liczba2);
                int result = first + second;
                out.print("Liczba pierwsza to : " + liczba1);
                out.print("<br>");
                out.print("Liczba druga to : " + liczba1);
                out.print("<br>");
                out.print("Wynik Zadania 1 to : " + result);
            }
            else {
                out.print("Podaj poprawane parametry w URL");
            }


        %>
        </tbody>
    </table>

    <p>Dziesiaj jest : <%=java.time.LocalDateTime.now().toString()%></p>

</div>
<a href="http://www.google.pl">GOOGLE</a>


<h1>
    ZADANIE 2
</h1>

<%
    //wyciągnięcie atrybutów z requestu
    String productName = request.getParameter("productName");
    String productCount = pageContext.getRequest().getParameter("productCount");
    if (productName == null || productCount == null) {
        out.print("Podaj parametry");
    } else {
        int productCountInt = Integer.parseInt(productCount);

        //wyciągniece mapy produktów z sesji
        Map<String, Integer> productsMap = (Map<String, Integer>) session.getAttribute("paroductsMap");

        //obsłużenie przypadku, gdy w sesji nie ma jeszcze mapy z prodktam
        if (productsMap == null) {
            HashMap<String, Integer> newProductsMap = new HashMap<>();
            newProductsMap.put(productName, productCountInt);
            session.setAttribute("paroductsMap", newProductsMap);

        } else {

            Integer max=0;
            for (Map.Entry<String,Integer>mapEntity:productsMap.entrySet()){
                if(mapEntity.getValue()>max){
                    max=mapEntity.getValue();
                }
            }
            response.addCookie(new Cookie("maxPriceProduct", max.toString()));

            productsMap.put(productName, productCountInt);
            session.setAttribute("paroductsMap", productsMap);
        }
    }

%>



<table style="border: 1px black solid">
    <tbody style="border: 1px black solid">
    <%
        Map<String, Integer> produtMapToDisplay = (Map<String, Integer>) session.getAttribute("paroductsMap");
        if (produtMapToDisplay != null) {
            for (Map.Entry<String, Integer> mapEntity : produtMapToDisplay.entrySet()) {

    %>
    <tr>
        <td>
            <% out.print(mapEntity.getKey());%>
        </td>
        <td>
            <% out.print(mapEntity.getValue());%>
        </td>
    </tr>

    <%}%>
    <%}%>

    </tbody>
</table>

<div>
    Pamietaj o ${cookie.get("maxPriceProduct")}

</div>

<jsp:include page="/login.jsp"/>

<jsp:useBean id="calculatorBean"
             class="demoJsp.MyCalculatorBean"
             scope="session" />

<jsp:setProperty name="calculatorBean" property="multiplyNumber" value="10"/>
<jsp:setProperty name="calculatorBean" property="addingNumber" value="2"/>

<%
    int add=calculatorBean.add(100);
    int multiply=calculatorBean.multiply(100);
    out.print("<br>");
    out.print(add);
    out.print("<br>");
    out.print(multiply);


%>


</body>
</html>
