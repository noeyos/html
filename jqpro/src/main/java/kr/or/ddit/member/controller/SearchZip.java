package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImple;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchZip
 */
@WebServlet("/searchZip.do")
public class SearchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchZip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 안 깨지게 인코딩 작업 - 주소 한글이니까
		request.setCharacterEncoding("utf-8");
		
		// 요청시 전송데이터 받기 - dong
		String zipCode = request.getParameter("dong");
		
		// service 객체 얻기
		IMemberService service = MemberServiceImple.getService();
		
		// service 메소드 호출 - 결과값 얻기 - List 
		List<ZipVO> list = service.searchZip(zipCode);
		
		// 결과값을 request에 저장
		request.setAttribute("searchZip", list);
		
		// view페이지로 이동 - json데이터 생성
		request.getRequestDispatcher("/0601/searchZip.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
