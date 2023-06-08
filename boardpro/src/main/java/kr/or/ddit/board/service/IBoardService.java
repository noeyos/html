package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public interface IBoardService {
	// 페이지별 리스트 가져오기 
	public List<BoardVO> listPerPage(Map<String, Object> map);
	// 글 갯수 
	public int totalCount(Map<String, Object> map); 
	//글쓰기 - 저장하기 
	public int insertBoard(BoardVO vo);
	// 페이지 정보 얻기 
	public PageVO getInfo(int page, String stype, String sword);
}
