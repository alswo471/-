package contreller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.KanbanDto;
import service.KanbanException;
import service.WorkInfoService;
import service.WorkUpdateService;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		KanbanDto kanban = null;
		try {
			kanban = new WorkInfoService().get(req);
		} catch (KanbanException e) {
			out.println("<script>alert('" + e.getMessage() + "'); history.back();</script>");
			e.printStackTrace();
		}
		
		req.setAttribute("kanban", kanban);
		RequestDispatcher rd = req.getRequestDispatcher("main/update.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		try {
			WorkUpdateService service = new WorkUpdateService();
			service.process(req);
			out.println("<script>parent.location.replace('main');</script>");
		} catch (Exception e) {
			out.println("<script>alert('" + e.getMessage() + "');</script>");
		}
	}

}
