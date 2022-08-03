<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 
 <c:forTokens var="word" items="사과1 1231231321321321321321321오렌지12332454542132123132415678132684321876187651878328132 5파인애플2132132435453234354 2멜론" delims="123456789">
 ${word}<br> 
 </c:forTokens>
  