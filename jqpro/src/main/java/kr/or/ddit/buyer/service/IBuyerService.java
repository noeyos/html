package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerService {
	
//	public 리턴결과형 메소드이름(타입 파라미터변수)
	public List<BuyerVO> getBuyerName();
	
	
	public BuyerVO getBuyerInfo(String id);
	
	
}
