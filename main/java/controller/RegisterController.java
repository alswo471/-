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
		//body 에 대한 기본 인코딩도 꺠지기 때문에  명시해줘야함..
		req.setCharacterEncoding("UTF-8");
		
		//한글이 깨지기떄문에 인코딩 과 text/html 넣어야함
		resp.setContentType("text/html; charset=utf-8");
		
		//출력하는 부분 가져오기 
		PrintWriter out = resp.getWriter();
		
		try {
			WRService service = new WRService();
			service.process(req); 
			}catch (ErpException e) {
				e.printStackTrace();
				out.println("<script>alert('" + e.getMessage()+ "');</script>");
			}
	}

}
