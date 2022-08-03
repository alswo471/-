<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="date" value="<%=new Date() %>"/>

<fmt:setLocale value="ko_KR"/>
<fmt:formatDate value="${date }" type="both"/><br>

<fmt:setLocale value="en_US"/>
<fmt:formatDate value="${date }" type="both"/><br>

<fmt:setLocale value="ja_JP"/>
<fmt:formatDate value="${date }" type="both"/><br>