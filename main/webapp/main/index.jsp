<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../outline/header.jsp"/>
<h2>작업 추가</h2>
<form name="frmRegist" method ="post" action="<c:url value="/register"/> " target ="ifrmProcess">

<div class='status_wrap'>
<input type="radio" name="status" value="READY" id=status_READY checked>
<label for="status_READY">준비중</label>

<input type="radio" name="status" value="PROGRESS" id=status_PROGRESS>
<label for="status_PROGRESS">진행중</label>


<input type="radio" name="status" value="DONE" id=status_DONE>
<label for="status_DONE">완료</label>
</div>

<input type="text" name="workNm" placeholder="작업내용 입력...">
<button type="submit">등록하기</button>
</form>

<h2>작업 목록</h2>

<form name="frmDelete=" id="frmDelete" method="post" action="<c:url value="/delete"/>" target="ifrmProcess">
<table border='1'>
<thead>
<tr>
<th width='30'>
<input type='checkbox'id='select-all'>
</th>
<th width='100'>작업상태</th>
<th>작업내용</th>
<th width='100'>등록일</th>
</tr>
</thead>


<tbody>
<c:forEach var="kanban" items='${list}'>
<tr>
<td>
<input type='checkbox' name='id' value='${kanban.id}'>
</td>
<td>
<c:choose>
<c:when test="${kanban.status == 'READY'}">
준비중
</c:when>
<c:when test="${kanban.status == 'PROGRESS'}">
진행중
</c:when>
<c:when test="${kanban.status == 'DONE'}">
완료
</c:when>
</c:choose>
</td>
<td>${kanban.workNm}</td>
<td>${kanban.regDt}</td>
<td>
<a href="<c:url value="/update?id=${kanban.id}"/>">[작업 수정]</a>
</td>
</tr>

</c:forEach>
</tbody>
</table>
<button type="submit" onclick="return confirm('정말 삭제하시겠습니까?');">선택 작업 삭제하기</button>
</form>
<jsp:include page="../outline/footer.jsp"/>