<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP : Java Server Page</h1>

<%

	// post일때만 작성한다. get일땐 작성하지 않음. 이미 server.xml에서 작성해서 설정해줌.
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("id");
	int userNum = Integer.parseInt(request.getParameter("num"));
	String userFile = request.getParameter("file");
	
	// DB처리, 파일처리 - java i/o
	
	
%>

<p> 아이디 : <%= userId %> </p>
<p> 번호 : <%= userNum %> </p>
<p> 파일 : <%= userFile %> </p>

</body>
</html>