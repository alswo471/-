<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
 <%
 String[] fruits = {"사과","오렌지","파인애플","멜론"};
 %>
 
 <c:set var="fruits" value="<%=fruits%>"/>
 
 <c:forEach var="cnt" begin="1" end="10" step= "3">
 ${cnt}. 반복!<br>
 </c:forEach>
 
 <c:forEach var="fruits" items= "${fruits}" varStatus="status">
${status.current}<br>
index : ${status.index}<br>
count: ${status.count}<br>
first: ${status.first}<br>
last: ${status.last}<br>
-----------------<br>
 </c:forEach>