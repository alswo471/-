package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.WRService;
import service.ErpException;

@WebServlet("/register")
public class RegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		try {
			WRService service = new WRService();
			service.process(req); 
			out.println("<script>parent.location.reload();</script>");
			}catch (ErpException e) {
				e.printStackTrace();
				out.println("<script>alert('" + e.getMessage()+ "');</script>");
			}
	}

}
