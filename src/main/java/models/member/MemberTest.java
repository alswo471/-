package models.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class MemberTest {
public static void main(String[] args) {
	SqlSession sqlSession = Connection.getSqlSession();
	
	MemberDto member = new MemberDto();
	member.setMemId("user1");
	member.setMemPw("123456");
	member.setMemNm("사용자1");
	member.setEmail("alswo471@test.org");
	member.setMobile("01000000000");
	
	int affectedRows = sqlSession.insert("MemberMapper.register", member);
	System.out.println("반영된 레코드 수" + affectedRows);
	System.out.println(member);
	
	List<MemberDto> members = sqlSession.selectList("MemberMapper.members");
	System.out.println(members);
	sqlSession.commit();
	sqlSession.close();
}
}
