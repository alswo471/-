package models.member;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;
public class MemberDao {
	
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	
	public MemberDto register(MemberDto member) {
		SqlSession sqlSession = Connection.getSqlSession();
		
		int affectedRows = sqlSession.insert("MemberMapper.register", member);
		
		sqlSession.commit();
		sqlSession.close();
		
		if(affectedRows < 1 ) 
			return null;
		
		return member;
	}
	
	//회원 조회
	public MemberDto get(String memId) {
		SqlSession sqlSession = Connection.getSqlSession();
		MemberDto param = new MemberDto();
		param.setMemId(memId);
		
		MemberDto member = sqlSession.selectOne("MemberMapper.member", param);
		sqlSession.close();
		
		return member;
	}
	
	public static MemberDao getInstance() {
		if(instance == null ) {
			instance = new MemberDao();
		}
		
		return instance;
	}
}
