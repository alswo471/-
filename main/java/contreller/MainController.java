package contreller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.KanbanDto;
import service.WorkListService;

public class MainController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WorkListService service = new WorkListService();
		List<KanbanDto> list = service.gets(req);
		System.out.println(list);
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("main/index.jsp"); 
		rd.forward(req, resp);
	}

}
