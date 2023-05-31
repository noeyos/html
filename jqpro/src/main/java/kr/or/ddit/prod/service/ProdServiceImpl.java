package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService{

	// dao객체 필요 - 생성
	private IProdDao dao;
	private static IProdService service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService() {
		if(service == null) service = new ProdServiceImpl();
		return service;
	}
	
	

	@Override
	public List<ProdVO> getProdName(String lgu) {
//		// 리턴타입 변수 선언
//		List<ProdVO> list = null;
//		
//		// dao메소드 실행
//		list = dao.getProdName(lgu);
//		
//		// 결과 리턴
//		return list;
		
		// 한줄요약
		return dao.getProdName(lgu);
	}

	@Override
	public ProdVO getProdDetail(String id) {
//		ProdVO vo = null;
//		
//		vo = dao.getProdDetail(id);
//		
//		return vo;
		
		return dao.getProdDetail(id);
	}

}
