package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BookDTO;


public class BookDAO
{
	PreparedStatement pstmt=null;
	Connection con=null;
	BookDTO dto=new BookDTO();
	
	public boolean insert(BookDTO dto)
	{
      boolean res=false;
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
		pstmt.setInt(1,0);
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getAuthor());
		pstmt.setString(4,dto.getPublisher());
		pstmt.setDouble(5, dto.getPrice());
		pstmt.setInt(6, dto.getQuantity());
		pstmt.setString(7, dto.getCategary());
		int nori=pstmt.executeUpdate();
		if(nori==1)
		{
			res=true;
		}
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return res;
	}
	
	public boolean update(BookDTO Udto)
	{
		boolean res=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("update book SET BookName=?,Author=?, Publisher=?, Categary=?, Price=?, Quantity=? Where BookID=?");

			pstmt.setString(1, Udto.getBookName());
			pstmt.setString(2, Udto.getAuthor());
			pstmt.setString(3, Udto.getPublisher());
			pstmt.setString(4, Udto.getCategary());
			pstmt.setDouble(5, Udto.getPrice());
			pstmt.setInt(6, Udto.getQuantity());
			pstmt.setInt(7, Udto.getBookID());
			System.out.println("BookDAO");
			System.out.println("BookName:"+Udto.getBookName());
			System.out.println("Author:"+Udto.getAuthor());
			System.out.println("Publisher:"+Udto.getPublisher());
			System.out.println("Categary:"+Udto.getCategary());
			System.out.println("Price:"+Udto.getPrice());
			System.out.println("Quantity:"+Udto.getQuantity());
			int nora=pstmt.executeUpdate();
			if(nora>=1)
			{
				res=true;
				System.out.println("your book updated");
			}
			
		}
			
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return res;
	}
	
	public List<BookDTO> DeleteBook(BookDTO dto)
		{
			List<BookDTO> book=new ArrayList<BookDTO>();
	      
	      try 
	      {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("delete from book WHERE BookName like '"+dto.getBookName()+"%' and Author like '"+dto.getAuthor()+"%' and Publisher like '"+dto.getPublisher()+"%' and Price = "+dto.getPrice()+""); 
			
		
			int nori=pstmt.executeUpdate();
			if(nori>=1)//while(nori>=1)
			{
				System.out.println( nori+"Book is deleted from database");				
			}
			else
				
			{
				System.out.println("Book is not deleted or the book is not there");
			}
			
	      } 
	      catch (ClassNotFoundException e) 
	      {
			
			e.printStackTrace();
	      }
	      catch (SQLException e) {
			
			e.printStackTrace();
		}
	      if(pstmt!=null)
	      {
	    	  try {
				pstmt.close();
			} catch (SQLException e) 
	    	  {
				
				e.printStackTrace();
			}
	      }
	      if(con!=null)
	      {
	    	  try
	    	  {
				con.close();
			} 
	    	  catch (SQLException e) 
	    	  {
				
				e.printStackTrace();
			}
	      }
	      return book;
		}
	
	public List<BookDTO> searchBook(BookDTO dto)
	{
		List<BookDTO> book=new ArrayList<BookDTO>();
      
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from book WHERE BookName like '%"+dto.getBookName()+"%' and Author like '%"+dto.getAuthor()+"%' and Publisher like '%"+dto.getPublisher()+"%' and Price <= "+dto.getPrice()+""); 

		ResultSet rs= pstmt.executeQuery();
		while(rs.next())
		{
			BookDTO dto1=new BookDTO();
			
			dto1.setBookID(rs.getInt(1));
			
			dto1.setBookName(rs.getString(2));
			dto1.setAuthor(rs.getString(3));
			dto1.setPublisher(rs.getString(4));
			dto1.setPrice(rs.getDouble(5));
			dto1.setQuantity(rs.getInt(6));
			dto1.setCategary(rs.getString(7));
			
			book.add(dto1);
			
		}
		
		System.out.println("number="+book.size());
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return book;
	}
	
	
	public BookDTO searchBook(String BookName)
	{
		boolean res=false;
		BookDTO dto1=new BookDTO();
      
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from book WHERE BookName=?"); 
		pstmt.setString(1, BookName);
	
		ResultSet rs= pstmt.executeQuery();
		if(rs.next())
		{
			
			
			dto1.setBookID(rs.getInt(1));
			dto1.setBookName(rs.getString(2));
			dto1.setAuthor(rs.getString(3));
			dto1.setPublisher(rs.getString(4));
			dto1.setPrice(rs.getDouble(5));
			dto1.setQuantity(rs.getInt(6));
			dto1.setCategary(rs.getString(7));
			
			
			
			
		}
		
		System.out.println(dto1);
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return dto1;
	}
	
	public boolean updatequantity(BookDTO dto)
	{
		
		boolean res=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("update book SET Quantity=Quantity-1 Where BookID=?");

			
			pstmt.setInt(1, dto.getBookID());
			System.out.println("BookDAO");
			
			System.out.println("Quantity:"+dto.getQuantity());
			int nora=pstmt.executeUpdate();
			if(nora>=1)
			{
				res=true;
				System.out.println("your book updated");
			}
			
		}
			
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return res;
	}
	
	/*public BookDTO searchAuthor(String Author)
	{
      boolean res=false;
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from book WHERE Author=? ");
		
		pstmt.setString(1, dto.getAuthor());
		pstmt.setString(3, dto.getPublisher());
		
		pstmt.setDouble(4, dto.getPrice());
		
		OR Author=? OR Publisher=? OR Price=?
		
		ResultSet rs= pstmt.executeQuery();
		if(rs.next())
		{
			dto.setBookID(rs.getInt(1));
			dto.setBookName(rs.getString(2));
			dto.setAuthor(rs.getString(3));
			dto.setPublisher(rs.getString(4));
			dto.setPrice(rs.getDouble(5));
			dto.setQuantity(rs.getInt(6));
			dto.setCategary(rs.getString(7));
				
		}
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return dto;
	}
	public BookDTO searchPublisher(String Publisher)
	{
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from book WHERE Publisher=? ");
		
		
		pstmt.setString(1, dto.getPublisher());
		
		
		ResultSet rs= pstmt.executeQuery();
		if(rs.next())
		{
			dto.setBookID(rs.getInt(1));
			dto.setBookName(rs.getString(2));
			dto.setAuthor(rs.getString(3));
			dto.setPublisher(rs.getString(4));
			dto.setPrice(rs.getDouble(5));
			dto.setQuantity(rs.getInt(6));
			dto.setCategary(rs.getString(7));
				
		}
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return dto;
	}
	public BookDTO searchPrice(Double Price)
	{
      
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from book WHERE Price=? ");
		
	
		
		pstmt.setDouble(1, dto.getPrice());
		
		ResultSet rs= pstmt.executeQuery();
		if(rs.next())
		{
			dto.setBookID(rs.getInt(1));
			dto.setBookName(rs.getString(2));
			dto.setAuthor(rs.getString(3));
			dto.setPublisher(rs.getString(4));
			dto.setPrice(rs.getDouble(5));
			dto.setQuantity(rs.getInt(6));
			dto.setCategary(rs.getString(7));
				
		}
		
      } 
      catch (ClassNotFoundException e) 
      {
		
		e.printStackTrace();
      }
      catch (SQLException e) {
		
		e.printStackTrace();
	}
      if(pstmt!=null)
      {
    	  try {
			pstmt.close();
		} catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      if(con!=null)
      {
    	  try
    	  {
			con.close();
		} 
    	  catch (SQLException e) 
    	  {
			
			e.printStackTrace();
		}
      }
      return dto;
	}
	
*/
	public List<BookDTO> selectAll()
	{
		
		PreparedStatement pstmt=null;
		Connection con=null;
		

			List<BookDTO> book=new ArrayList<BookDTO>();
	      
	      try 
	      {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("select * from book "); 
			
		
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
				BookDTO dto1=new BookDTO();
				
				dto1.setBookID(rs.getInt(1));
				dto1.setBookName(rs.getString(2));
				dto1.setAuthor(rs.getString(3));
				dto1.setPublisher(rs.getString(4));
				dto1.setPrice(rs.getDouble(5));
				dto1.setQuantity(rs.getInt(6));
				dto1.setCategary(rs.getString(7));
				book.add(dto1);
			}
		}
			 catch (ClassNotFoundException e) 
					{
					
					e.printStackTrace();
					} 
			catch (SQLException e) 
					{
				
					e.printStackTrace();
					}
				
				finally
				{
					if(con!=null)
					{
						try {
							con.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
					if(pstmt!=null)
					{
						try {
							pstmt.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}

			}
return book;
	}

	public boolean updatequantity1(int BookID)
	{
		
		boolean res=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("update book SET Quantity=Quantity+1 Where BookID=?");

			
			pstmt.setInt(1, dto.getBookID());
			System.out.println("BookDAO");
			
			System.out.println("Quantity:"+dto.getQuantity());
			int nora=pstmt.executeUpdate();
			if(nora>=1)
			{
				res=true;
				System.out.println("your book updated");
			}
			
		}
			
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return res;
	}

	public List<BookDTO> RecentBook()
	{
		
		PreparedStatement pstmt=null;
		Connection con=null;
		

			List<BookDTO> book=new ArrayList<BookDTO>();
	      
	      try 
	      {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("SELECT * FROM book ORDER BY BookID DESC LIMIT 5"); 
			
		
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
				BookDTO dto1=new BookDTO();
				
				dto1.setBookID(rs.getInt(1));
				dto1.setBookName(rs.getString(2));
				dto1.setAuthor(rs.getString(3));
				dto1.setPublisher(rs.getString(4));
				dto1.setPrice(rs.getDouble(5));
				dto1.setQuantity(rs.getInt(6));
				dto1.setCategary(rs.getString(7));
				book.add(dto1);
			}
		}
			 catch (ClassNotFoundException e) 
					{
					
					e.printStackTrace();
					} 
			catch (SQLException e) 
					{
				
					e.printStackTrace();
					}
				
				finally
				{
					if(con!=null)
					{
						try {
							con.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
					if(pstmt!=null)
					{
						try {
							pstmt.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}

			}
return book;
	}
}
