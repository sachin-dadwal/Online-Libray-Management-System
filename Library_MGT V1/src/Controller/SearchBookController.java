package Controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import DTO.BookDTO;
import DTO.UserDTO;

/**
 * Servlet implementation class SearchController
 */
public class SearchBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDAO dao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session != null) 
		{
			doPost(request, response);
		} else
		{
			response.sendRedirect("SearchBookName.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
		BookDTO dto= new BookDTO();
		String message="";
		
		response.setContentType("text/html");
		
		double Price=10000.0;
		String BookName=request.getParameter("BookName");
		String Author=request.getParameter("Author");
		String Publisher=request.getParameter("Publisher");
		String price1=request.getParameter("Price");
		{
			if(!(price1.equals("")))
			{
				 Price=Double.parseDouble(request.getParameter("Price"));
			}
			
		}
		
		dto.setBookName(BookName);
		dto.setAuthor(Author);
		dto.setPublisher(Publisher);
		dto.setPrice(Price);
		/*System.out.println(BookName);
		System.out.println(Author);
		System.out.println(Publisher);
		System.out.println(Price);*/
		
	List<BookDTO> books=dao.searchBook(dto);
	request.setAttribute("Books", books);
	System.out.println(books);
	request.getRequestDispatcher("DisplaySearchBook.jsp").forward(request, response);
	request.setAttribute("message", message);
	
	
	
	
	
	
	//request.getRequestDispatcher("ISActive.jsp").forward(request,response);
	
	
		//boolean res=dao.insert(dto);
		
	/*	if(res)
		{
			message="student DATA inserted sucessfully";
			
		}
		else
		{
			message="oops something went wrong";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("register.jsp").forward(request,response);*/
		
		
	}



		
		
		
	}


