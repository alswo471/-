<%@ page contentType= "text/html; charset=utf-8"%>

<%
	request.setAttribute("num1", 20);
	request.setAttribute("num2", 30);
	
	Integer num1 = (Integer)request.getAttribute("num1");
	Integer num2 = (Integer)request.getAttribute("num2");
	out.println(num1 + num2);
%>
 	${num1 + num2}

