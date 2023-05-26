package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerName
 */
@WebServlet("/buyerName.do")
public class BuyerName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전송시 데이터를 받는다


		// service객체 얻는다
		IBuyerService service = BuyerServiceImpl.getService();

		// service메소드 호출 - 수행결과를 얻는다
		List<BuyerVO> list = service.getBuyerName();
		
		// request객체로 결과를 저장한다
		request.setAttribute("getBuyerName", list);

		// view페이지로 이동 - 수행결과로 응답데이터를 생성 - json
		request.getRequestDispatcher("/0526/buyerName.jsp").forward(request, response);
		
			
	}

}
