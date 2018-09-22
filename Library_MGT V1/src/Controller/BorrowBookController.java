package Controller;



import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class BorrowBookController
 */
public class BorrowBookController extends HttpServlet
{
	 BorrowDAO dao= new BorrowDAO();
	 BookDAO bdao=new BookDAO();
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
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
		
		HttpSession session = request.getSession(false);
		
		UserDTO dto=new UserDTO();
	

		String message="";
		if (session != null) 
		{
			/*
			Scanner sc=new Scanner(System.in);
			int BookID=Integer.parseInt(request.getParameter("bookId"));
			UserDTO mydto = (UserDTO) session.getAttribute("UserDTO");
			
			//request.getRequestDispatcher("Activate_status.jsp").forward(request,response);
			PrintWriter pw=response.getWriter();
		    BookDTO bdto=new BookDTO();
			System.out.println(BookID);
			//System.out.println(mydto.getUID());
			boolean res=dao.insert(mydto.getUID(), BookID);*/

			Scanner sc=new Scanner(System.in);
			int BookID=Integer.parseInt(request.getParameter("bookId"));
			UserDTO buydto = (UserDTO)session.getAttribute("UserDTO");
			
			//request.getRequestDispatcher("Activate_status.jsp").forward(request,response);
			PrintWriter pw=response.getWriter();
		    BookDTO bdto=new BookDTO();
		    bdto.setBookID(BookID);
			System.out.println(BookID);
			int u=buydto.getUID();
			int u1=(Integer)session.getAttribute("userid");
			System.out.println(u1);
			boolean res=dao.insert(buydto.getUID(), BookID);
		

		
		if(res)
			{
			boolean b=bdao.updatequantity(bdto);
			System.out.println(b);
			
		
				
			System.out.println("Book borrowed sucessfully");
				message="Book borrowed sucessfulyy";
			
		System.out.println(buydto.getUID());
		boolean res1=dao.update(buydto.getUID());
		System.out.println(res1);
		if(res1)
		{ 
			System.out.println(" book Data updated sucessfully");
		}
			}
		else
		{
			System.out.println("oops something went wrong........");
			message="oop something went wrong";
		}
			
		request.setAttribute("message", message);
		request.getRequestDispatcher("BorrowBook.jsp").forward(request,response);
	}
			else
			{
				System.out.println("User not validated by admin");
			}

}
	}

