package models.member;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import org.mindrot.bcrypt.BCrypt;
/**
 * 
 * 회원 가입 처리
 * @author alswo
 *
 */
public class JoinService {
	public void join(HttpServletRequest request) {
		MemberValidator vaildator = new MemberValidator();
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPwRe = request.getParameter("memPwRe");
		String memNm = request.getParameter("memNm");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		//필수 데이터 검증 
		Map<String, String> requiredFields = new HashMap<>();
		requiredFields.put("memId", "아이디를 입력하세요");
		requiredFields.put("memPw", "비밀번호를 입력하세요");
		requiredFields.put("memPwRe", "비밀번호를 확인해주세요");
		requiredFields.put("memNm", "회원명을 입력하세요");
		
		vaildator.requiredCheck(request, requiredFields);
		
		//중복 회원 체크
		vaildator.duplicateMember(memId);
		
		//3. 아이디 비밀번호 복잡성 체크 
		vaildator.checkMemId(memId);
		vaildator.checkMemPw(memPw);
		
		//4. 비밀번호 해쉬화(bcrypt)
		String hash = BCrypt.hashpw(memPw, BCrypt.gensalt(12));
	}
}
