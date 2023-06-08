<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 서블릿에서 저장한 데이터 꺼내기
	int res = (Integer)request.getAttribute("upload");
	
	if(res>0) {		// 1 : 성공
%>
		{
			"flag" : "가입을 축하합니다"
		}
<%
	} else {		// 0 : 실패
%>
		{
			"flag" : "가입 실패"		
		}
<%	
	}
%>