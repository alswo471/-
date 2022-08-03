<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:catch var="e">
 
<%
int num1=100;
int num2=0;

out.println(num1/num2);
%>
 </c:catch>
 <c:if test="${!empty e}">
  ${e.message}
 </c:if>
 
 