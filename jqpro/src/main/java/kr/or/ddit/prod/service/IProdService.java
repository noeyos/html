package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {
	
	// prod 이름 출력, id값 얻어오기
	public List<ProdVO> getProdName(String lgu);
	
	
	public ProdVO getProdDetail(String id);
	
	
}
