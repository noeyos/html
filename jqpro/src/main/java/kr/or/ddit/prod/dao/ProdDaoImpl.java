package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao{
	
	// 자기 자신의 객체를 생성해서 리턴
	private static IProdDao dao;
	
	public static IProdDao getDao() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}

	@Override
	public List<ProdVO> getProdName(String lgu) {
		// sqlSession 생성
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		
		// return 타입 변수 선언
		List<ProdVO> list = null;
		
		try {
			// mapper 실행
			list = sqlSession.selectList("prod.getProdName", lgu);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return list;
	}

	@Override
	public ProdVO getProdDetail(String id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		
		ProdVO vo = null;
		
		try {
			vo = sqlSession.selectOne("prod.getProdDetail", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return vo;
	}

}
