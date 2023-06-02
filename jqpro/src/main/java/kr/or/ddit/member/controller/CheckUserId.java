package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImple;

/**
 * Servlet implementation class CheckUserId
 */
@WebServlet("/checkUserId.do")
public class CheckUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 전송데이터 받기 - id
		String inputId = request.getParameter("id");
		
		// service 객체 얻기
		IMemberService service = MemberServiceImple.getService();
		
		// service 메소드 호출 - 결과값 얻기 - String 
		String res = service.checkUserId(inputId);
		
		// 결과값을 request에 저장
		request.setAttribute("checkUserId", res);
		
		// view페이지로 이동 - json데이터 생성
		request.getRequestDispatcher("/0601/CheckUserId.jsp").forward(request, response);
	}

}
