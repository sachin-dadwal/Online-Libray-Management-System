package DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserDTO;


public class UserDAO 
{
	PreparedStatement pstmt=null;
	Connection con=null;
	public boolean insert(UserDTO dto)
	{
		boolean res=false;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "tiger");
			//String Query=
			pstmt=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstmt.setInt(1,0);
			
			pstmt.setString(2,dto.getUserName());
			pstmt.setString(3,dto.getPassword());
			pstmt.setInt(4,dto.getMobile());
			pstmt.setString(5,dto.getEmail());
			pstmt.setString(6,dto.getAddress());
			
			int nori=pstmt.executeUpdate();
			if(nori==1)
			{
				res=true;
				System.out.println("registered sucessfully");
			}
		}
		catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
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
				try 
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
				
					e.printStackTrace();
				}
			}
		}
		
		return res;
		
	}
	public boolean delete(UserDTO dto)

	{
		boolean res=true;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "tiger");
			pstmt=con.prepareStatement("delete from user WHERE UserName=?");
			pstmt.setString(1,dto.getUserName());
			
			int nori=pstmt.executeUpdate();
			if(nori==1)
			{
				res=false;
			}
		}
		catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
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
				try 
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
				
					e.printStackTrace();
				}
			}
		}
		
		return res;
		
	}
	public UserDTO login(UserDTO dto)
	{
	try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "tiger");
			pstmt=con.prepareStatement("select * from user WHERE userName=? AND Password=?");
			pstmt.setString(1,dto.getUserName());
			pstmt.setString(2,dto.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setUID(rs.getInt(1));
				dto.setMobile(rs.getInt(4));
				dto.setEmail(rs.getString(5));
				dto.setAddress(rs.getString(6));
				
			}
		}
		catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
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
				try 
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
				
					e.printStackTrace();
				}
			}
		}
		
		return dto;
		
	}
	public boolean search(UserDTO dto)
	{
		boolean res=false;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "tiger");
			pstmt=con.prepareStatement("select * from user WHERE userName=?");
			pstmt.setString(1,dto.getUserName());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				res=true;
				int UID=rs.getInt(dto.getUID());
				String UserName=rs.getString(dto.getUserName());
				String Password=rs.getString(dto.getPassword());
				int Mobile=rs.getInt(dto.getMobile());
				String Email=rs.getString(dto.getEmail());
				String Address=rs.getString(dto.getAddress());
				System.out.println(UID+"\t"+UserName+"\t"+Password+"\t"+Mobile+"\t"+Email+"\t"+Address);
				
			}
		}
		catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
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
				try 
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
				
					e.printStackTrace();
				}
			}
		}
		
		return res;
		
	}

	public boolean forget(UserDTO dto)
	{
		boolean res=false;
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("Select * from user where username=?  AND email=?");
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getEmail());
					
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				res=true;
				System.out.println("Valid  ");
			}
			else
			{
				System.out.println("invalid , please try again ");
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
	public boolean update(String Password,String UserName)
	{
		boolean res=false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","tiger");
			pstmt=con.prepareStatement("update user set Password=? where UserName=?");
			pstmt.setString(1,Password);
			pstmt.setString(2,UserName);
			
			System.out.println(UserName);
			System.out.println(Password);
			
			int nori=pstmt.executeUpdate();
			if(nori >=1)
			{
				res=true;
				System.out.println("Password sucessfully Updated");
				
			}
			else
			{
				System.out.println("not updated, try again");
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
			catch (SQLException e) 
			{
			
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
	
}

