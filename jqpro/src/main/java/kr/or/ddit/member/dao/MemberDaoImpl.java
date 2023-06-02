package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	
	private static IMemberDao dao;
	
	// 싱글톤
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public String checkUserId(String id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		String userId = null;
		
		try {
			userId = sqlSession.selectOne("member.checkUserId", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return userId;
	}

	@Override
	public int uploadUser(MemberVO memVo) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		int check = 0;
		
		try {
			check = sqlSession.insert("member.uploadUser", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return check;
	}

	@Override
	public List<ZipVO> searchZip(String dong) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		List<ZipVO> list = null;
		
		try {
			list = sqlSession.selectList("member.searchZip", dong);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit(); 
			sqlSession.close();
		}
		
		return list;
	}

}
