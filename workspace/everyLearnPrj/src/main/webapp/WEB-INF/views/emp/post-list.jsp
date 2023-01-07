<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/el/resources/css/emp/post-list.css">
<link rel="stylesheet" href="/el/resources/css/common/reset.css">
<link rel="stylesheet" href="/el/resources/css/common/font.css">
<link rel="icon" type="image/png" sizes="16x16" href="/el/resources/img/logo/favicon-16x16.png">
</head>

<body>

<%@ include file="/WEB-INF/views/common/emp-header.jsp"%>

<main id="container">
	<div class="emp-container">
		<div class="emp">
			<div class="emp-wrapper">
				<ul class="announcement">
				<c:forEach items="${list}" var="list" begin="0" end="${fn:length(list)}" step="1">
					<li>
						<div class="announcement-wrapper">
							<a href="/el/emp/position?no=${list.no}">
								<figure class="img-wrapper">
									<img src="/el/resources/img/logo/logo_white.png" alt="img">
								</figure>
								<div class="emp-info">
									<div>
										<div class="emp-name">${list.companyName}</div>
										<a href="/el/emp/position?no=${list.no}" class="position">${list.title}</a>
									</div>
									<ul class="skill">
										<li>${list.sector}</li>
									</ul>
									<div class="etc">
										<span>${list.career} | </span> <span>${list.address}</span>
									</div>
								</div>
							</a>
						</div>
					</li>
				</c:forEach>
			</div>
		</div>
	</ul>
	<nav class="page-area">
		<ul>
		<c:if test="${pv.currentPage != 1}">
				<li>
					<c:if test="${empty keyword }">
						<a id="before" href="/el/emp/job-post?pno=${pv.currentPage-1}">이전</a>
					</c:if>
					<c:if test="${!empty keyword }">
						<a id="before" href="/el/emp/job-post/search?pno=${pv.currentPage-1}&keyword=${keyword}">이전</a>
					</c:if>
				</li>
		</c:if>
		<c:forEach var="num" begin="${pv.startPage }" end="${pv.endPage }">
				<li>
						<a class="numBtn" href="/el/emp/job-post?pno=${num}">${num}</a>
				</li>
		</c:forEach>
		<c:if test="${pv.currentPage != pv.maxPage && pv.maxPage != 0}">
				<li>
						<a id="after" href="/el/emp/job-post?pno=${pv.currentPage+1}">다음</a>                       		
				</li>
		</c:if>
		</ul>
	</nav>
	</div>
</main>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>