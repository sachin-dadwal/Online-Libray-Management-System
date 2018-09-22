package Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao=new UserDAO();
	UserDTO dto= new UserDTO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		String message="";
		PrintWriter pw=response.getWriter();
		/*int UID=Integer.parseInt(request.getParameter("UID"));*/
		String UserName=request.getParameter("UserName");
		String Password=request.getParameter("Password");
		Integer Mobile=Integer.parseInt(request.getParameter("Mobile"));
		//Integer.parseInt(request.getParameter(Password));
		String Email=request.getParameter("Email");
		String Address=request.getParameter("Address");
		
	
		/*if(session!=null)
		{
		request.getSession(false);	
		UserDTO dto=(UserDTO) request.getAttribute("UserDTO");
		
		String email=dto.getEmail();
		dto.setUID(UID);*/
		
		
		dto.setUserName(UserName);
		dto.setPassword(Password);
		dto.setEmail(Email);
		dto.setMobile(Mobile);
		dto.setAddress(Address);
		boolean res=dao.insert(dto);
		//HttpSession session=null;
		if(res)
		{ 
			session.setAttribute("UserName", UserName);
			session.setAttribute("Password", Password);
			message="User registred sucessfully";
			pw.println("DATA inserted sucessfully");
			request.setAttribute("message", message);
			request.getRequestDispatcher("Home1.jsp").forward(request,response);
		}
		else
		{
			message="oops something went wrong";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
		}
}
				
	
	
	


