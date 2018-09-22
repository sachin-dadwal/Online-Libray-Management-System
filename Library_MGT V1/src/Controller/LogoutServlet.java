package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			System.out.println("id="+session.getId());
			session.invalidate();
			session=null;
			System.out.println("logging out session");
			response.sendRedirect("index.html");
		}
		else
		{
			response.sendRedirect("index.html.jsp");
		}
	}


}