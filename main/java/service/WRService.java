package service;

import javax.servlet.http.HttpServletRequest;

import dao.ErpDao;
import dto.ErpDto;
import constants.Sports;

public class WRService {
	
	public void process(HttpServletRequest request) {
		/** 데이터 유효성 검사 S */
		
		String sports = request.getParameter("sports");
		String sportNm = request.getParameter("sportNm");
		int workoutSet = Integer.parseInt(request.getParameter("workoutSet"));
		int workoutNum = Integer.parseInt(request.getParameter("workoutNum"));
		
		if(sports == null || sports.trim().isEmpty()) {
			throw new ErpException("운동 한 부위를 선택하세요");
		}
		if(sportNm == null || sportNm.trim().isEmpty()){
			throw new ErpException("운동 종목을 입력 하세요");
		}
		
		if(workoutSet == 0){
			throw new ErpException("세트 수 를 입력하세요");
		}
		
		if(workoutNum == 0){
			throw new ErpException("횟수를 입력하세요");
		}
		
		/** 데이터 유효성 검사 E */
		
		/** 등록 처리 */
		ErpDto erpdto = new ErpDto();
		erpdto.setSports(Enum.valueOf(Sports.class, sports));
		erpdto.setSportNm(sportNm);
		erpdto.setWorkoutSet(workoutSet);
		erpdto.setWorkoutNum(workoutNum);
		
		ErpDao erpdao = new ErpDao();
		erpdao.register(erpdto);
	}
}
