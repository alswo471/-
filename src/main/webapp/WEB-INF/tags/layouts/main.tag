<%@ tag description="공통 레이아웃" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" type="java.lang.String" %>
<layout:common title = "${title}">

	<jsp:attribute name="header">
	<header>
	<section class = 'top-menu'>
	<a href="<c:url value="/member/join"/>">회원가입</a>
	<a href="<c:url value="/member/login"/>">회원가입</a>
	</section>
	<section class = 'logo'>로고</section>
	
	</header>
	
	</jsp:attribute>
	<jsp:attribute name="menu">
	<nav>
	<a href="#">운동 추가</a>
	<a href="#">운동 수정</a>
	<a href="#">운동 삭제</a>
	</nav>
	</jsp:attribute>
	
	<jsp:attribute name="footer">
	
	<footer>
	&copy; Copyright...
	</footer>
	</jsp:attribute>

	<jsp:body>
<main>
	<jsp:doBody />
</main>
	</jsp:body>

</layout:common>