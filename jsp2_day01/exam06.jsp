<%@ page contentType= "text/html; charset=utf-8"%>
${header['User-Agent']}<br>
JSESSIONID: ${cookie.JSESSIONID.value}<br>
p1 : ${initParam.param1}<br>
p2 : ${initParam.param2}<br>

RequestURL : ${pageContext.request.requestURI}
