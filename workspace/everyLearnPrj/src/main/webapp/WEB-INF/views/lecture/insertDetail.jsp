<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/el/resources/css/lecture/insertDetail.css" />
<link rel="stylesheet" href="/el/resources/js/lecture/insert.js" />
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main id="container">

		<div class="wrap">
			<div id="wrap-top">
				<div id="cate-name">강의 등록</div>
			</div>
			<div id="insert-index">

				<input type='button' 
					value='행 추가' 
					onclick='addRow()'>

			<form action="/el/lecture/insert/detail" method="post">
			<input type="hidden" name="bno" value="${bno }">
				<table id="index-table">
					<tr>
						<th>목차</th>
						<th>해당 클래스 이름</th>
					</tr>
					<tr>
						<th>예시) 1</th>
						<th>예시) 프로크리에이트 설치하기</th>
					</tr>
					<tr>
						<td><input type="number" name="no"  class="table-input" placeholder="숫자만 입력해주세요"></td>
						<td><input type="text" name="chapter" class="table-input"  placeholder="제목을 입력해주세요"></td>
					</tr>
					<tr>
						<td><input type="number" name="no" class="table-input"  placeholder="숫자만 입력해주세요"></td>
						<td><input type="text" name="chapter" class="table-input" placeholder="제목을 입력해주세요"></td>
					</tr>
					<tr>
						<td><input type="number" name="no" class="table-input" placeholder="숫자만 입력해주세요"></td>
						<td><input type="text" name="chapter" class="table-input" placeholder="제목을 입력해주세요"></td>
					</tr>
					

				</table>
				
				<div id="next"><button type="submit" id="nextbtn">작성하기</button></div>
				
				</form>
			</div>


		</div>
	
	</main>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>

<script>
	function addRow() {

		var objRow;
		objRow = document.all["index-table"].insertRow();

		//숫자
		var objCell_index = objRow.insertCell();
		objCell_index.innerHTML = '<input type="number" name="no" class="table-input"  placeholder="숫자만 입력해주세요">';

		//목차명
		var objCell_name = objRow.insertCell();
		objCell_name.innerHTML = '<input type="text" name="chaper" class="table-input"  placeholder="제목을 입력해주세요">';
		
		
		
	}

</script>
</html>