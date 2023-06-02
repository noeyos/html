package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImple implements IMemberService{

	private IMemberDao dao;
	private static IMemberService service;
	
	// dao객체 얻어오기
	private MemberServiceImple() {
		dao = MemberDaoImpl.getDao();
	}
	
	// 싱글톤
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImple();
		return service;
	}
	
	@Override
	public String checkUserId(String id) {
		return dao.checkUserId(id);
	}

	@Override
	public int uploadUser(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.uploadUser(memVo);
	}

	@Override
	public List<ZipVO> searchZip(String dong) {
		// TODO Auto-generated method stub
		return dao.searchZip(dong);
	}

}
