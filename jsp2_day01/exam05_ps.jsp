<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8" />
아이디 : ${param.memId}
<br>
이름 : ${param.memNm}
<br>
비밀번호 : ${param.memPw}
<br>
취미 :  <c:forEach var="hobby" items= "${paramValues.hobby}">
${hobby}
</c:forEach>
 


