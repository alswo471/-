<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="floor"  value="5"/>
<c:choose>
<c:when test="${floor == 1}">
1층입니다.
</c:when>
<c:when test="${floor == 2}">
2층입니다.
</c:when>
<c:when test="${floor == 3}">
3층입니다.
</c:when>
<c:otherwise>
없는 층 입니다.
</c:otherwise>
</c:choose>