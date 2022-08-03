package service;

import javax.servlet.http.HttpServletRequest;

import dto.KanbanDto;
import dao.KanbanDao;



public class WorkInfoService {
	public KanbanDto get(HttpServletRequest request) {
		/** 데이터 유효성 검사 S */
		String id = request.getParameter("id");
		if(id == null || id.trim().isEmpty()) {
			throw new KanbanException("잘못된 접근입니다.");
		}
		
		KanbanDto kanban = new KanbanDao().get(Integer.valueOf(id));
		if(kanban == null) {
			throw new KanbanException("등록되지 않은 작업입니다.");
		}
		/** 데이터 유효성 검사 E */
		return kanban;
	}
}
