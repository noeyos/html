package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao{
	// 자기 자신의 클래스 객체 선언, 생성, 리턴 
	private static IBoardDao dao;
	
	public static IBoardDao getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	public BoardDaoImpl() {}

	@Override
	public List<BoardVO> listPerPage(Map<String, Object> map) {
		
		// 1. 리턴 변수 선언
		int count = 0;
		List<BoardVO> list = null;
		
		// 2. list = mapper 실행
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("board.listPerPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		// 3. 결과 리턴  
		return list;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		// 1. 리턴 변수 선언
		int count = 0;
		
		// 2. list = mapper 실행
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			count = session.selectOne("board.totalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		// 3. 결과 리턴  
		return count;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		
		try {
			res = session.insert("board.insertBoard",vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = session.update("board.updateBoard",vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		int res = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			res = session.delete("board.deleteBoard",num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public int updateHit(int num) {
		int hit = 0;
		SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		try {
			hit = session.update("board.updateHit",num);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return hit;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("reply.insertReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		SqlSession session = null;
		List<ReplyVO> list = null;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			list = session.selectList("reply.listReply", bonum);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("reply.updateReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteReply(int renum) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("reply.deleteReply", renum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}


}
