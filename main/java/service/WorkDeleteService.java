package service;

import javax.servlet.http.HttpServletRequest;

import dao.KanbanDao;

public class WorkDeleteService {
public void process(HttpServletRequest request) {
		/** 데이터 유효성 검사 S */
	String[] ids = request.getParameterValues("id");
	if(ids == null || ids.length == 0) {
		throw new KanbanException("삭제할 작업을 선택하세요.");
	}
	/** 데이터 유효성 검사 E */
	
	/** 삭제 처리 S */
	KanbanDao dao = new KanbanDao();
	for(String id : ids) {
		dao.delete(Integer.valueOf(id));
	}
	
	/** 삭제 처리 E */
	}
}
