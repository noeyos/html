package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;



@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 요청시 데이터 받기
		
		
		// service객체 얻기
		ILprodService service = LprodServiceImpl.getService();
		
		// service 메소드 호출 - 결과값 받기
		List<LprodVO> list = service.getAllLprod();
		
		// 결과값을 request에 저장
		request.setAttribute("getAllLprod", list); 
		
		
		// view 페이지로 이동 - html태그를 이용하여 출력 / json데이터 생성
		request.getRequestDispatcher("/0530/lprodList.jsp").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
