package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	// 아이디 중복 검사
	public String checkUserId(String id);
	
	
	// 저장하기
	public int uploadUser(MemberVO memVo);
	
	
	// 우편번호 검색하기
	public List<ZipVO> searchZip(String dong);
	
}
