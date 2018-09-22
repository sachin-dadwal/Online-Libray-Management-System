package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.BookDTO;
import DTO.BorrowDTO;
import DTO.UserDTO;


public class BorrowDAO 
{
Connection con=null;
PreparedStatement pstmt=null;

BorrowDTO bto=new BorrowDTO();
public boolean insert(int userId,int bookId)
{
	boolean res=false;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("insert into borrow values(?,?,?,?,?)");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");		
		
		
		
		pstmt.setInt(1, 0);
		pstmt.setInt(2, userId);
		pstmt.setInt(3, bookId);
		pstmt.setString(4,new java.util.Date().toString());
		pstmt.setString(5,"no");
		
		
		int nori=pstmt.executeUpdate();
		if(nori==1)
		{
			res=true;
		}
	}
	catch (ClassNotFoundException e) 
	{
	
		e.printStackTrace();
	} catch (SQLException e) 
	{
	
		e.printStackTrace();
	}
	if(con!=null)
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	if(pstmt!=null)
	{
		try 
		{
			pstmt.close();
		}
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
	}
	
	 
	return res;
	
}
public boolean delete(BookDTO dto)
{
	boolean res=false;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("DELETE FROM borrow WHERE BookID=?");
	
		System.out.println(dto.getBookID());
		pstmt.setInt(1, dto.getBookID());
		int nori=pstmt.executeUpdate();
		
		
		if(nori>=1)
		{
			res=true;
			System.out.println("deleted sucessfully");
		}
		else
		{
			System.out.println("book is not present please try again");
		}
		
	}
	catch (ClassNotFoundException e) 
	{
	
		e.printStackTrace();
	} catch (SQLException e) 
	{
	
		e.printStackTrace();
	}
	if(con!=null)
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	if(pstmt!=null)
	{
		try 
		{
			pstmt.close();
		}
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
	}
	
	 
	return res;
	
}

public boolean update(int BookID)
{
	boolean res=false;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("UPDATE borrow SET IsActive=? WHERE BookID=?");
			
		pstmt.setString(1,"Yes");
		pstmt.setInt(2, BookID);
		
		
		int nori=pstmt.executeUpdate();
		System.out.println(nori);
		if(nori>=1)
		{
			res=true;
			System.out.println("Book is borrowed sucessfully");
		}
	}
	catch (ClassNotFoundException e) 
	{
	
		e.printStackTrace();
	} catch (SQLException e) 
	{
	
		e.printStackTrace();
	}
	if(con!=null)
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	if(pstmt!=null)
	{
		try 
		{
			pstmt.close();
		}
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
	}
	
	return res;
}

public List<BorrowDTO> selectAll()
{
	
	PreparedStatement pstmt=null;
	Connection con=null;
	

		List<BorrowDTO> book=new ArrayList<BorrowDTO>();
      
      try 
      {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
		pstmt=con.prepareStatement("select * from borrow "); 
		
	
		ResultSet rs= pstmt.executeQuery();
		while(rs.next())
		{
			BorrowDTO dto1=new BorrowDTO();
			
			
			dto1.setBID(rs.getInt(1));
			dto1.setUID(rs.getInt(2));
			dto1.setBookID(rs.getInt(3));
			dto1.setDate(rs.getString(4));
			dto1.setIsActive(rs.getString(5));
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

