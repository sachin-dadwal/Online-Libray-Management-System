package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.BorrowDTO;
import DTO.PurchaseDTO;

public class PurchaseDAO
{
	Connection con=null;
	PreparedStatement pstmt=null;
	public boolean insert(int uid, int bid)
                                                    
	{
		PurchaseDTO dto=new PurchaseDTO();
		boolean res=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("insert into purchase values(?,?,?,?,?)");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, uid);
			pstmt.setInt(3,bid);
			pstmt.setString(4,new java.util.Date().toString());
			pstmt.setString(5,"no");
			
			System.out.println(uid);
			System.out.println(bid);
			System.out.println(new java.util.Date().toString());
			
						
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
		catch (SQLException e)
		{
		
			e.printStackTrace();
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
		if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) 
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
			pstmt=con.prepareStatement("UPDATE purchase SET Status=? WHERE BookID=?");
				
			pstmt.setString(1,"Yes");
			pstmt.setInt(2, BookID);
			
			
			int nori=pstmt.executeUpdate();
			System.out.println(nori);
			if(nori>=1)
			{
				res=true;
				System.out.println("Book is purchased sucessfully");
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

	public List<PurchaseDTO> selectAll()
	{
		
		PreparedStatement pstmt=null;
		Connection con=null;
		

			List<PurchaseDTO> book=new ArrayList<PurchaseDTO>();
	      
	      try 
	      {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("select * from purchase"); 
			
		
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
				PurchaseDTO dto1=new PurchaseDTO();
				
				
				dto1.setCartNo(rs.getInt(1));
				dto1.setUID(rs.getInt(2));
				dto1.setBookID(rs.getInt(3));
				dto1.setDate(rs.getString(4));
				dto1.setStatus(rs.getString(5));
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