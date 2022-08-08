<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../outline/header.jsp" />
<h2>운동기록 추가</h2>
<form name="frmRegist" method="post" action="<c:url value="/register"/>" target="ifrmProcess">

<div class = 'sports_wrap'>
	<input type="radio" name="sports" value="CHEST" id="sports_CHEST">
	<label for="sports_CHEST">가슴</label>
	
	<input type="radio" name="sports" value="BACK" id="sports_BACK">
	<label for="sports_back">등</label>
	
	<input type="radio" name="sports" value="SHOULER" id="sports_SHOULER">
	<label for="sports_shoulder">어깨</label>
	
	<input type="radio" name="sports" value="LOWERBODY" id="sports_LOWERBODY">
	<label for="sports_lowerbody">하체</label>
	
	<input type="radio" name="sports" value="ARM" id="sports_ARM">
	<label for="sports_CHEST">팔</label>
</div>

	<input type="text" name="sportNm" size ="30" placeholder="운동 종목 입력(bench press 등..)"><br>
	<input type="text" name="workoutSet" size ="30" placeholder="세트 수...(숫자만 입력하세요)"><br>
	<input type="text" name="workoutNum" size ="30" placeholder="횟수...(숫자만 입력하세요)"><br>
	<button type="submit">등록하기</button>

</form>
<jsp:include page="../outline/footer.jsp" />