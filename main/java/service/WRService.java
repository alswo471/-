package service;

import javax.servlet.http.HttpServletRequest;

public class WRService {
	//데이터 검증 
	public void process(HttpServletRequest request) {
		// 데이터 유효성 검사
		String sports = request.getParameter("sports");
		String sportNm = request.getParameter("sportNm");
		
		if(sports == null || sports.trim().isEmpty()) {
			throw new ErpException("운동 한 부위를 선택하세요");
		}
		if(sportNm == null || sportNm.isBlank()) {
			throw new ErpException("운동 종목을 입력 하세요");
		}
	}
}
