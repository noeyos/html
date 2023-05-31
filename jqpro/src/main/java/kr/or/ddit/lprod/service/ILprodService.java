package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public interface ILprodService {

	// lprod 전체 리스트
	
//	public 리턴결과형(resultType) 메소드이름(parameterType 변수명) {}
	public List<LprodVO> getAllLprod();
}
