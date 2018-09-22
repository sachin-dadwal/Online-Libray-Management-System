package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 * Servlet implementation class ForgetController1
 */
public class ForgetController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   UserDAO dao=new UserDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String message="";
		UserDTO dto =new UserDTO();
		String password=request.getParameter("pwd2");
		String user=request.getParameter("UserName");
		
		System.out.println("Password:"+password);
		System.out.println("Username:"+user);
		
		boolean res=dao.update(password, user);
		if(res)
		{
			System.out.println("Successfully updated password");
			message="Successfully updated password";
		}
		else
		{
			System.out.println("not updated , try again");
			message="not updated successfully";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
	}

}
