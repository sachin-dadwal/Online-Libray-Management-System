package Controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import DAO.BookDAO;
import DTO.BookDTO;

public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HttpSession session=null;
       BookDAO dao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(session!=null)
		{
			doPost(request,response);
		}
		else
		{
			response.sendRedirect("UpdateBook.jsp");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("-------------in controler");
		HttpSession session=request.getSession(false);
		BookDTO dto=new BookDTO();
		String message="";
		
		if(session!=null)
		{
			dto.setBookID(Integer.parseInt(request.getParameter("BookID")));
			dto.setBookName(request.getParameter("BookName"));
			dto.setAuthor(request.getParameter("Author"));
			dto.setCategary(request.getParameter("Categary"));
			dto.setPrice(Double.parseDouble(request.getParameter("Price")));
			dto.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
			dto.setPublisher(request.getParameter("Publisher"));
			Double p=Double.parseDouble(request.getParameter("Price"));
			int q=Integer.parseInt(request.getParameter("Quantity"));
			String c=request.getParameter("Categary");
		
			System.out.println(p);
		System.out.println(q);
		System.out.println(c);
		
	System.out.println(request.getParameter("BookName"));
	System.out.println("----------");
			
			
			
		
		boolean res=dao.update(dto);
		System.out.println(res);
	if(res)
	{
		System.out.println("updated sucessfully");
		message="Data Updated sucessfully";
	}
		}
	else{
		System.out.println("Oops");
		message="Data not updated ";
	}
		String BookName=request.getParameter("BookName");
		//request.setAttribute("message", message);
		//request.getRequestDispatcher("UpdateBook1.jsp").forward(request, response);
		//request.getRequestDispatcher("UpdateBook.jsp").forward(request, response);
		session.setAttribute("BookName", BookName);
		request.setAttribute("BookName", BookName);
		
//		request.getRequestDispatcher("AddBook.jsp").forward(request,response);
		request.getRequestDispatcher("uploadphoto.jsp").forward(request,response);
	}

}
