<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="msg" value="메세지(pageContext)" scope="page"/>
<c:set var="msg" value="메세지(request))" scope="request"/>
<c:set var="msg" value="메세지(application)" scope="application"/>
<c:remove var="msg" scope="request"/>
pageContext : ${pageScope.msg}<br>
request : ${requestScope.msg}<br>
application : ${applicationScope.msg}<br>