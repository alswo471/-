<%@ page contentType= "text/html; charset=utf-8"%>

<%
pageContext.setAttribute("msg", "pageContext Msg");
request.setAttribute("msg", "request Msg");
application.setAttribute("msg", "application Msg");
request.setAttribute("msg-1", "r");
%>

pageScope : ${pageScope.msg}<br>
requestScope : ${requestScope.msg}<br>
applicationScope : ${applicationScope.msg}<br>

${requestScope['msg-1']}