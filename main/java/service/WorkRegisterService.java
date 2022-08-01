package service;


import javax.servlet.http.HttpServletRequest;

import dao.KanbanDao;
import dto.KanbanDto;
import constants.Status;


public class WorkRegisterService {
	
	public void process(HttpServletRequest requset) {
		/** 데이터 유효성 검사 S */
		String status = requset.getParameter("status");
		String workNm = requset.getParameter("workNm");
		
		if(status == null || status.trim().isEmpty()) {
			throw new KanbanException("작업 상태를 선택하세요");
		}
		
		if(workNm == null || workNm.trim().isEmpty()) {
			throw new KanbanException("작업 내용을 입력하세요.");
		}
		
		/** 데이터 유효성 검사 E */
		
		/** 등록 처리 */
		KanbanDto kanban = new KanbanDto();
		kanban.setStatus(Enum.valueOf(Status.class, status));
		kanban.setWorkNm(workNm);
		KanbanDao dao = new KanbanDao();
		dao.register(kanban);
		
	}
}
