<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 서블릿에서 저장한 데이터 꺼내기
BuyerVO vo = (BuyerVO)request.getAttribute("getBuyerInfo");


%>

{
	"id" : "<%= vo.getBuyer_id() %>",
	"name" : "<%= vo.getBuyer_name() %>",
	"lgu" : "<%= vo.getBuyer_lgu() %>",
	"comtel" : "<%= vo.getBuyer_comtel() %>",
	"bank" : "<%= vo.getBuyer_bank() %>",
	"bankno" : "<%= vo.getBuyer_bankno() %>",
	"bankname" : "<%= vo.getBuyer_bankname() %>",
	"mail" : "<%= vo.getBuyer_mail() %>",
	"zip" : "<%= vo.getBuyer_zip() %>",
	"add1" : "<%= vo.getBuyer_add1() %>",
	"add2" : "<%= vo.getBuyer_add2() %>"
}