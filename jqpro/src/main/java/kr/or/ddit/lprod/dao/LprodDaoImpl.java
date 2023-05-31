package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class LprodDaoImpl implements ILprodDao{

	private static ILprodDao dao;
	
	public static ILprodDao getDao() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	@Override
	public List<LprodVO> getAllLprod() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		
		List<LprodVO> list = null;
		
		try {
			list = sqlSession.selectList("lprod.getAllLprod");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return list;
	}
	

}
