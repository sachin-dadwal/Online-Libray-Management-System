<%-- <%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="DTO.BookDTO"%>
	<%@ page import="DAO.BookDAO"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,private,must-reavalidate,max-stale=0,post-check=0,pre-check=0");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires","0");%>

	<%!BookDAO bdao = new BookDAO();%>
<div align="center">
	<%
		List<BookDTO> book = bdao.selectAll();
		String message = (String) request.getAttribute("message");
		if(message!=null)
		{%>
		<h1><%=message%></h1>
			
		<%}
	%>
	<h1><a href="Home.jsp">Home</a></h1>
	
		<h1>Available books to borrow</h1>
		<br>
		<h2><a href="LogoutServlet">LogOut</a></h2>
		<table border=5>
			<%
				for (BookDTO Book : book) {
			%>
			<tr>
				<td>BookID:
					<h3><%=Book.getBookID()%></h3>
				</td>
				<td>BookName:
					<h3><%=Book.getBookName()%></h3>
				</td>
				<td>Author:
					<h3><%=Book.getAuthor()%></h3>
				</td>
				<td>Publisher:
					<h3><%=Book.getPublisher()%></h3>
				</td>
				<td>Price:
					<h3><%=Book.getPrice()%></h3>
				</td>
				<td>Quantity:
					<h3><%=Book.getQuantity()%></h3>
				</td>
				<td>Categary:
					<h3><%=Book.getCategary()%></h3>
				</td>
				<td>
					<form action="BorrowBookController" method="post">
						<input type="hidden" name=bookId value=<%=Book.getBookID()%>><input
							type="submit" value="borrow">
					</form>
				</td>
</tr>
				<%
				}
			%>
		</table>
	</div>
--%>
 
 <!DOCTYPE html>

<html>
<div class="agile-login" align="center">
<h1>Welcome to Oxford Liberary</h1>
</div>
<%-- <%
response.setHeader("Cache-Control", "no-cache,no-store,private,must-reavalidate,max-stale=0,post-check=0,pre-check=0");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires","0");%> --%>
<head>

<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- stylesheets -->
	<link rel="stylesheet" href="css/font-awesome.css">
	<link rel="stylesheet" href="css/style.css">
	<!-- google fonts  -->
	<link href="//fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700" rel="stylesheet">

<link rel="stylesheet" href="css/font-awesome.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>


<%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="DTO.BookDTO"%>
	<%@ page import="DAO.BookDAO"%>
<%!BookDAO bdao = new BookDAO();%>

<div class="navbar">


  <b><a href="Home1.jsp">Home</a></b>
  <a href="Register.jsp">Register</a>
  <a href="SelectAllBookController">All Available Books</a>
  <a href="BuyBook.jsp">Buy Book</a>
  <a href="BorrowBook.jsp">Borrow Book</a>
  <a href="ReturnBook.jsp">Return Book</a>
      
     
  <div class="dropdown">
    <button class="dropbtn">Search Book
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="SearchBookName.jsp">Search BookName</a>
      <a href="SearchBookAuthor.jsp">Search Author</a>
      <a href="SearchBookPublication.jsp">Search Publication</a>
      <a href="SearchBookPrice.jsp">Search Price</a>
    </div>
  </div> 
  
 <button onclick= "myFunction()"><a href="LogoutServlet">LogOut</a></button>
</div>


<script>
function myFunction() {
    alert("You are Logout");
}

</script>

<div align="left">


<%
		List<BookDTO> book = bdao.selectAll();
		String message = (String) request.getAttribute("message");
		if(message!=null)
		{%>
		<h1><%=message%></h1>
			
		<%}
	%>
	<div class="agile-login">
			<h1><mark>Available books to borrow</mark></h1>
			<div class="w3ls-form">
			
				
		<%
			/* List<BookDTO> book = (List<BookDTO>) request.getAttribute("Books"); */
			
			if (book != null)
			{%>
				
<div align="left" height=1500px width=100px>
<table border=5>
			<%
				for (BookDTO Book : book) {
			%>

<td height=100px width=120px> <img alt=" Add Image" src="http://localhost:8080/Library_MGT_V1/images/upload/<%=Book.getBookName()%>.jpg"  width=160px height=140px></td>
				
				<%-- <td><h2><b><mark>BookID:</mark></b></h2><h2><div align="center"><font color='white'><%=Book.getBookID()%></font></div></h2></td>
				<td><h2><b><mark>BookName:</mark></b></h2><h2><div align="center"><font color='white'><%=Book.getBookName()%></font></div></h2></td>
				<td><h2><div align="center">Author:</font></div></h2><h2><div align="center"><font color='white'><%=Book.getAuthor()%></font></div></h2></td>
				<td><h2><div align="center"><font color='white'>Publisher:</font></div></h2><h2><div align="center"><%=Book.getPublisher()%></div></h2></td>
				<td><h2><div align="center"><font color='white'>Price:</font></div></h2><h2><div align="center"><%=Book.getPrice()%></div></h2></td>
				<td><h2><div align="center"><font color='white'>Quantity:</font></div></h2><h2><div align="center"><%=Book.getQuantity()%></div></h2></td>
				<td><h2><div align="center">Categary:</div></h2><h2><div align="center"><%=Book.getCategary()%></div></h2></td> --%>
	
				
<td><h2><b><div align="center"><font color='yellow'><u>BookID:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getBookID()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>BookName:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getBookName()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>Author:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getAuthor()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>Publisher:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getPublisher()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>Price:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getPrice()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>Quantity:</u></font></div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getQuantity()%></font></div></b></h3></td>
<td><h2><b><div align="center"><font color='yellow'><u>Categary:</div></b></h2><br><h3><b><div align="center"><font color='white'><%=Book.getCategary()%></div></b></h3></td>
				
				<td>
								<form action="BuyBookController" method="post">
						<input type="hidden" name=bookId value=<%=Book.getBookID()%>>
						<h2><b><div align="center"><i><u><mark>_ Borrow_</mark></u></i></div></b></h2><input type="submit" value="Borrow">
					</form>
					</td>
					</tr>

				
			<%
				}
			%>


			<%
				}
			%>


			</table>
		
					</div>
					</div>
				
				
					
 

<footer>
<br><br><br><br><br><br><br><br>

<div class="copyright">
		<p>© 2017 Winter Login. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	</footer>
</div>
</body>
</html>









	