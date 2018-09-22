package Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 * Servlet implementation class LoginController
 */
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao=new UserDAO();
	UserDTO dto= new UserDTO();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String message="";
		String UserName=request.getParameter("username");
		//String Password=request.getParameter("password");
		dto.setUserName(UserName);
		//dto.setPassword(Password);
		boolean res=dao.delete(dto);
		if(res)
		{
			System.out.println("user deleted");
			message=" user deleted";
			pw.println("Welcome user deleted");
		
		}
		else
		{
			message="oops something went wrong";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("Delete.jsp").forward(request, response);	
	}

}
