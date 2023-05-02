<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
color : #01579B}

table {
	border : 3px solid #4DD0E1;
}

td {
	width : 300px;
	height : 50px;
	text-align: center;
}

.bold {
	font-weight : bold;
	font-size : 20px;
	background : #B2EBF2;
}

</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>

<%

	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String tel = request.getParameter("tel");
	String mail = request.getParameter("mail");
	String area = request.getParameter("area");
	
	// area값에는 엔터기호(\r\n)가 포함
	// \n을 <br>태그로 변환
	String textArea = area.replaceAll("\n", "<br>");
	String scar = request.getParameter("carsingle");
	String[] mcar = request.getParameterValues("carmulti");
	
	String str = "";
	for(String car : mcar) {
		str += car + "&nbsp;&nbsp;";
	}
	
%>

<table border="1">
	<tr>
		<td class="bold">아이디</td>
		<td><%= id %></td>
	</tr>
	<tr>
		<td class="bold">전화번호</td>
		<td><%= tel %></td>
	</tr>
	<tr>
		<td class="bold">이메일</td>
		<td><%= mail %></td>
	</tr>
	<tr>
		<td class="bold">고객의 의견</td>
		<td><%= textArea %></td>
	</tr>
		<tr>
		<td class="bold">자동차</td>
		<td><%= scar %></td>
	</tr>
		<tr>
		<td class="bold">자동차</td>
		<td><%= str %></td>
	</tr>
</table>

</body>
</html>