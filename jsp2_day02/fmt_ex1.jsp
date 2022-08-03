<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="date" value= "<%=new Date()%>"/>
<fmt:formatDate value= "${date}" type="both" dateStyle="short" timeStyle="short"/><br>

<fmt:formatDate value= "${date}" pattern="yyyy.MM.dd E a HH:mm:ss"/><br>
