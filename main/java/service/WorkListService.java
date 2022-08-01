package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.KanbanDao;
import dto.KanbanDto;

public class WorkListService {
	
	public List<KanbanDto> gets(HttpServletRequest request){
		List<KanbanDto> list = new KanbanDao().gets();
		
		return list;
	}
}
