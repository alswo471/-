package commons;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
/**
 * 에외를 alert 출력
 * @author alswo
 *
 */
public class Utils {
	public static void alertError(HttpServletResponse response, RuntimeException e) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('" + e.getMessage() + "')</script>");
		} catch (Exception e2) {
			
		}
		
		
	}
}
