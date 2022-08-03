<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="msg" value="메세지1" scope="page"/>
<c:set var="msg" value="메세지1" scope="request"/>

${msg}<br>
${pageScope.msg}<br>

<%
String[] fruits = {"사과","개과","지과","육과"};
%>

<c:set var="fruits" value="<%=fruits %>"/>

<c:forEach var="fruit" items= "${fruits}">
${fruit}
</c:forEach>

