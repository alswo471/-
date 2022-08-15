package models.member;

import java.util.regex.*;
import mybatis.Connection;

import org.apache.ibatis.session.SqlSession;

import commons.BadRequestException;
import commons.Validator;

public class MemberValidator implements Validator {
	public void duplicateMember(String memId) {
		SqlSession sqlSession = Connection.getSqlSession();
		MemberDto param = new MemberDto();
		param.setMemId(memId);
		
		int count = sqlSession.selectOne("MamberMapper.count", param);
		
		sqlSession.close();
		
		if(count > 0 ) {
			throw new BadRequestException("이미 등록된 회원입니다."); 
		}
	}
	//Id 복잡성 체크(자리수 6자리,알파벳,숫자)
	public void checkMemId(String memId) {
		if(memId.length() < 6) {
			throw new BadRequestException("아이디는 6자리 이상 입력하세요");
		}
		
		Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(memId);
		
		if(matcher.find()) {//숫자, 알파벳이 아닌 문자가 포함되어 있는 경우
			throw new BadRequestException("아이디는 알파벳과 숫자로만 입력하세요");
		}
	}
	
	public void checkMemPw(String memPw) {
		if(memPw.length() < 8) {
			throw new BadRequestException("비밀번호는 8자리 이상을 입력하세요");
		}
	}
 
}
