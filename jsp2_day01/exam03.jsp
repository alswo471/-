<%@ page contentType= "text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setAttribute("num", 15);
request.setAttribute("msg", "1234");
%>
<c:if test= "${empty msg}">
msg 값이 없습니다.
</c:if>

<c:if test= "${!empty msg}">
${msg}
</c:if>
<br>

<c:if test="${num >= 10}">
${num}는 10이상입니다.
</c:if>

<c:if test="${num < 10}">
${num}는 10미만입니다.
</c:if>

<br>
${num >= 10 ?  "10이상":"10미만"}



