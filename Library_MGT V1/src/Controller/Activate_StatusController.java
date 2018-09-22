package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.http.HttpSession;
import DAO.PurchaseDAO;
import DTO.BookDTO;
import DTO.UserDTO;


/**
 * Servlet implementation class Activate_StatusController
 */
public class Activate_StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
		 PurchaseDAO dao= new PurchaseDAO();
		 HttpSession session=null; 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			
			if (session != null) 
			{
			
				doPost(request, response);
				
			}
			else
			{
				response.sendRedirect("Active_status.jsp");
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
					System.out.println(res1);
					if(res1)
					{
						System.out.println("Data inserted sucessfully");
						message="Status updated sucessfully";
					}
					else
					{
						message="Status is not updated";
					}
					}
					request.setAttribute("message", message);
					request.getRequestDispatcher("Activate_status.jsp").forward(request,response);
	}
			}