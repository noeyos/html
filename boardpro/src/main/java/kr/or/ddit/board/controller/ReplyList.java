package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<ReplyVO> list = service.listReply(bonum);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/replyList.jsp").forward(request, response);
		
	}
}