package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdate() {
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
		
		// 요청시 전송데이타 받는다 - udata - writer, subject, mail, password, content, num
		BoardVO vo = new BoardVO();
		
		try {
			// BeanUtils.populate로 하면 request.getParameter("writer") ..("subject").. 이런식으로
			// 하나하나 받아야 되는 것들을 map으로 하나로 한번에 받을 수 있다.
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("writer = " + vo.getWriter());
		System.out.println("mail = " + vo.getMail());
		System.out.println("pw = " + vo.getPassword());
		System.out.println("sub = " + vo.getSubject());
		System.out.println("content = " + vo.getContent());
		System.out.println("num = " + vo.getNum());
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		
		// service 메소드 호출 - 결과값 받는다 - int
		int res = service.updateBoard(vo);
		
		
		// 결과값을 request에 저장
		request.setAttribute("result", res);
		
		
		// view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
