<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
/**
String[] zonelds = TimeZone.getAvailableIDs();
for(String zoneld : zonelds){
	out.println(zoneld + "<br>");
}
*/
%>
<c:set var="date" value="<%=new Date()%>"/>

<fmt:timeZone value="Asia/Seoul">
<fmt:formatDate value="${date}" type="both"/><br>
</fmt:timeZone>

<fmt:timeZone value="America/New_York">
<fmt:formatDate value="${date}" type="both"/><br>
</fmt:timeZone>

<fmt:timeZone value="Asia/Manila">
<fmt:formatDate value="${date}" type="both"/><br>
</fmt:timeZone>

<br>

<fmt:setTimeZone value="Asia/Seoul"/>
<fmt:formatDate value="${date}" type="both"/><br>

<fmt:setTimeZone value="America/New_York"/>
<fmt:formatDate value="${date}" type="both"/><br>

<fmt:setTimeZone value="Asia/Manila"/>
<fmt:formatDate value="${date}" type="both"/><br>