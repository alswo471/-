<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../outline/header.jsp"/>

<form method="post" action="<c:url value="/update"/>" target ="ifrmProcess">
<input type="hidden" name="id" value="${kanban.id}">
	<div class="status_wrap">
		<input type="radio" name="status" value="READY" id="status_READY" 
		${kanban.status == 'READY' ? " checked" : ""}> 
		<label for="status_READY">준비중</label> 
		
		<input type="radio" name="status" value="PROGRESS" id="status_PROGRESS"
		 ${kanban.status == 'PROGRESS' ? " checked" : "" }>
		<label for="status_PROGESS">진행중</label> 
		
		<input type="radio" name="status" value="DONE" id="status_DONE"
		 ${kanban.status == 'DONE' ? " checked" : "" }> 
		<label for="status_DONE">완료</label>
	</div>
	<input type="text" name="workNm" placeholder="작업내용 입력..." value="${kanban.workNm}">
	<button type="submit" onclick="return confirm('정말 수정하시겠습니까?');">수정하기</button>
</form>

<jsp:include page="../outline/footer.jsp"/>
