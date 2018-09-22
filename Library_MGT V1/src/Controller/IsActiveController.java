package Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BorrowDAO;
import DTO.BookDTO;
import DTO.UserDTO;

/**
 * Servlet implementation class IsActivateController
 */
public class IsActiveController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	 BorrowDAO dao= new BorrowDAO();
	 HttpSession session=null; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		if (session != null) 
		{
		
			doPost(request, response);
			
		}
		else
		{
			response.sendRedirect("ISActive.jsp");
		}
	}
	

   		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			
			HttpSession session = request.getSession(false);
			UserDTO dto=new UserDTO();
				

				String message="";
				if (session != null) 
				{
					
					Scanner sc=new Scanner(System.in);
					int BookID=Integer.parseInt(request.getParameter("bookId"));
					UserDTO mydto = (UserDTO) session.getAttribute("UserDTO");
					PrintWriter pw=response.getWriter();
				    BookDTO bdto=new BookDTO();
					System.out.println(BookID);
			
				//System.out.println(mydto.getUID());
				boolean res1=dao.update(BookID);
				if(res1)
				{
					System.out.println("Data inserted sucessfully");
					message="Data inserted sucessfully";
				}
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("ISActive.jsp").forward(request,response);
}
		}