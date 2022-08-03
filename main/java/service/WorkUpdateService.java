package service;

import javax.servlet.http.HttpServletRequest;

import constants.Status;
import dao.KanbanDao;
import dto.KanbanDto;
import java.util.*;
public class WorkUpdateService {
public void process(HttpServletRequest request) {
	/** 데이터 유효성 검사 S - id, status, workNm*/
	
	validator(request);
	
	/** 수정처리 S */
	KanbanDto kanban = new KanbanDto();
	kanban.setId(Integer.valueOf(request.getParameter("id")));
	kanban.setStatus(Enum.valueOf(Status.class, request.getParameter("status")));
	kanban.setWorkNm(request.getParameter("workNm"));
	
	new KanbanDao().update(kanban);
	/** 수정처리 E */
	
	}

private void validator(HttpServletRequest request) {
	Map<String, String> params = new HashMap<>();
	params.put("id", "잘못된 접근입니다.");
	params.put("status", "작업 상태를 선택하세요");
	params.put("workNm", "작업명을 입력하세요");
	
	for(Map.Entry<String, String>param : params.entrySet()) {
		String key = param.getKey();
		String msg = param.getValue();
		
		String p = request.getParameter(key);
		if(p == null || p.trim().isEmpty()) {
			throw new KanbanException(msg);
		}
	}
}
/** 데이터 유효성 검사 E */
}
