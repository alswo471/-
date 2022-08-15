package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss = {"text1", "text2"};
		req.setAttribute("addCss", addCss);
		
		String[] addJs = {"text3", "text4"};
		req.setAttribute("addJs", addJs);
		
		RequestDispatcher rd = req.getRequestDispatcher("/main/index.jsp");
		rd.forward(req, resp);
	}
	
}
