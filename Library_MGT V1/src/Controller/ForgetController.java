package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 * Servlet implementation class ForgetController
 */
public class ForgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	UserDAO dao=new UserDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String UserName=request.getParameter("UserName");
		String Email=request.getParameter("Email");
		System.out.println(UserName);
		System.out.println(Email);
		UserDTO dto=new UserDTO();
		dto.setEmail(Email);
		dto.setUserName(UserName);
		request.setAttribute("UserName", UserName);
	boolean res=dao.forget(dto);
	if(res)
	{
		System.out.println("Valid user");
		request.getRequestDispatcher("SetPassword.jsp").forward(request, response);
		
		
	
			
	}
	
	else
	{
		System.out.println("Wrong username or password");
		System.out.println("Please try again");
		request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
	}
	}

}