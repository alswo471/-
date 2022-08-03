<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test= "${param.num1 > 10}">
10보다 큰수
</c:if>

${param.num1 > 10 ? "10보다 큰 수" : "10이거나 작은 수"}