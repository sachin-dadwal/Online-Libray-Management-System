package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import DAO.UserDAO;
import DTO.BookDTO;
import DTO.UserDTO;

/*import com.jsp.liberary.DAO.BookDAO;
import com.jsp.liberary.DAO.UserDAO;
import com.jsp.liberary.DTO.BookDTO;
import com.jsp.liberary.DTO.UserDTO;*/

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO udao=new UserDAO();
	
	BookDAO bdao=new BookDAO();

	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDTO dto= new UserDTO();
		PrintWriter pw=response.getWriter();
		HttpSession session=null;
		response.setContentType("text/html");
		String message="";
		String UserName=request.getParameter("username");
		String Password=request.getParameter("password");
		dto.setUserName(UserName);
		dto.setPassword(Password);
		System.out.println(UserName);
		System.out.println(Password);
		if("admin".equalsIgnoreCase(UserName)&&"admin".equalsIgnoreCase(Password))
		{
			System.out.println("Welcome To the Library");
		System.out.println("admin welcome here");	
		message="Welcome To the Library";
		session=request.getSession(true);
		
		request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		
		}
			else
		{
		UserDTO mydto=udao.login(dto);
		if(mydto.getUID()>0)
		{
			session=request.getSession(true);
			
			session.setAttribute("UserDTO",mydto);
			
			int user=dto.getUID();
			dto.setUID(user);
			System.out.println(mydto);
			System.out.println("---------------------");
		System.out.println(user);			
		System.out.println("---------------------");
			session.setAttribute("userid",user);
			session.setAttribute("UserName", UserName);
			session.setAttribute("Password", Password);
			System.out.println("Welcome To the Liberary");
			System.out.println("---------------------");
			message="Welcome To the Liberary";
			request.setAttribute("message", message);
			request.setAttribute("UserName",UserName);
			System.out.println("---------------------");
			//List<BookDTO> books=bdao.searchBook(bdto);
			//request.setAttribute("Books", books);
			BookDTO bdto=new BookDTO();
			
			
			
			
			List<BookDTO> books=bdao.RecentBook();
			request.setAttribute("Books", books);
			request.getRequestDispatcher("Home1.jsp").forward(request, response);
			
		}
		else
		{
			/*System.exit(0);*/
			request.getRequestDispatcher("index.html").forward(request, response);
			message="oops something went wrong";
			request.setAttribute("message", message);
			
		}
	}
		
		
	}
}
