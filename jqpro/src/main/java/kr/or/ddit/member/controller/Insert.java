package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImple;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * // 전송시 데이터 받기 String uid = request.getParameter("id"); String uname =
		 * request.getParameter("name"); String upass = request.getParameter("pass");
		 * String ubir = request.getParameter("bir"); String uhp =
		 * request.getParameter("hp"); String umail = request.getParameter("mail");
		 * String uzip = request.getParameter("zip"); String uadd1 =
		 * request.getParameter("add1"); String uadd2 = request.getParameter("add2");
		 * 
		 * // vo에 저장 MemberVO vo = new MemberVO(); vo.setMem_id(uid);
		 * vo.setMem_name(uname); vo.setMem_pass(upass); vo.setMem_bir(ubir);
		 * vo.setMem_hp(uhp); vo.setMem_mail(umail); vo.setMem_zip(uzip);
		 * vo.setMem_add1(uadd1); vo.setMem_add2(uadd2);
		 */
		
		// 전송시 데이터 받기 - vo에 저장
		MemberVO vo = new MemberVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
			// vo의 변수랑 getParameter한 객체의 key값이랑 일치하는 것들의 값을 가져옴
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// service객체 얻기
		IMemberService service = MemberServiceImple.getService();
		
		// service메소드 호출하기 - 결과값 받기
		int res = service.uploadUser(vo);
		
		// 결과값을 request에 저장하기
		request.setAttribute("upload", res);
		
		// view페이지로 이동
		request.getRequestDispatcher("/0601/insert.jsp").forward(request, response);
		
		
		
		
	}

}
