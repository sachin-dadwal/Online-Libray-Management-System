package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RecentAddedBookController
 */
public class RecentAddedBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  HttpSession session=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(session!=null)
		{
			doPost(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

	}

}
