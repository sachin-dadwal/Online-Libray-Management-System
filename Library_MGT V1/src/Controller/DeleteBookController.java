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
import DAO.BorrowDAO;
import DTO.BookDTO;

/**
 * Servlet implementation class DeleteBookController
 */
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BookDAO dao=new BookDAO();
    HttpSession session=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(session!=null)
		{
			doPost(request,response);
			
		}
		else
		{
			response.sendRedirect("DeleteBook.jsp");
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BookDTO dto= new BookDTO();
		String message="";
		
		response.setContentType("text/html");
		
		double Price=0;
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
		
	List<BookDTO> books=dao.DeleteBook(dto);
	request.setAttribute("Books", books);
	
	request.getRequestDispatcher("DeleteBook.jsp").forward(request, response);
	
	
	
		
		
	}
	}



