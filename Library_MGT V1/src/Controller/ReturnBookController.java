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
import DAO.BorrowDAO;
import DTO.BookDTO;
import DTO.UserDTO;

/**
 * Servlet implementation class SearchController
 */
public class ReturnBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BorrowDAO dao=new BorrowDAO();
	BookDAO bdao= new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session != null) 
		{
			doPost(request, response);
		} else
		{
			response.sendRedirect("ReturnBook.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
		BookDTO dto= new BookDTO();
		String message="";
		
		response.setContentType("text/html");
		
		
		int BookID=Integer.parseInt(request.getParameter("BookID"));
		System.out.println(BookID);
		
		
		
		dto.setBookID(BookID);
	boolean res1=dao.delete(dto);
	
	
	System.out.println(res1);
	
	if(res1)
	{
		boolean res2=bdao.updatequantity1(BookID);
		System.out.println(res2);
		if(res2)
		{
			System.out.println("added back sucessfully");
		}
		System.out.println("Book returned sucessfully");
		message="Book returned sucessfully";
	}
		
	else
	{
		System.out.println("book not returned ");
		message="book not returned ";
	}
		request.setAttribute("message", message);
		request.getRequestDispatcher("ReturnBook.jsp").forward(request, response);	
			
	}
	}


