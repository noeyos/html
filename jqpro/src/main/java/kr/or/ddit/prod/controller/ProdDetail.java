package kr.or.ddit.prod.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;



@WebServlet("/prodDetail.do")
public class ProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송시 요청 데이터 받기 - id
		String prodId = request.getParameter("id");
		
		// service 객체 얻기
		IProdService service = ProdServiceImpl.getService();
		
		// service 메소드 호출하기 - 결과값 받기
		ProdVO vo = service.getProdDetail(prodId);
		
		// 결과값을 request에 저장하기
		request.setAttribute("prodDetail", vo);
		
		// view페이지로 이동 - json데이터 문자열 데이터 생성
		request.getRequestDispatcher("/0530/prodDetail.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
