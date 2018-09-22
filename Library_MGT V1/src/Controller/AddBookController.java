package Controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import DTO.BookDTO;


 /* Servlet implementation class AddController
 */
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO bdao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session != null) 
		{
			doPost(request, response);
		} else
		{
			response.sendRedirect("AddBook.jsp");
		}
		}
		 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
		BookDTO dto= new BookDTO();
		PrintWriter pw=response.getWriter();
		HttpSession session = request.getSession(false);
		String message="";
		String BookName=request.getParameter("BookName");
		//int BookID=Integer.parseInt(request.getParameter("BookID"));
		try
		{
		//String BookName=request.getParameter("BookName");
		
		String Author=request.getParameter("Author");
		String Publisher=request.getParameter("Publisher");
		String Categary=request.getParameter("Categary");
		int Quantity=Integer.parseInt(request.getParameter("Quantity"));
		double Price=Double.parseDouble(request.getParameter("Price"));
		
		
	
		dto.setBookName(BookName);
		dto.setAuthor(Author);
		dto.setPublisher(Publisher);
		dto.setQuantity(Quantity);
		dto.setPrice(Price);
		dto.setCategary(Categary);
		}
		catch(Exception e)
		{
			pw.println("write correct values");
		}
		
		boolean res=bdao.insert(dto);
		if(res)
		{	
		
			
			message=" DATA inserted sucessfully";
			
		}
		else
		{
			message="oops something went wrong";
		}
		session.setAttribute("BookName", BookName);
		request.setAttribute("BookName", BookName);
		
//		request.getRequestDispatcher("AddBook.jsp").forward(request,response);
		request.getRequestDispatcher("uploadphoto.jsp").forward(request,response);
		
	}
	
		
	}



