<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
 <c:url value="/board"/>
<c:url var="url" value="/board"/><br>
${url}
--%>
<c:set var="html" value= "<h1>출력!</h1><script>alert('출력!')</script>"/>
${html}
<c:out value="${html}"/>
 
 