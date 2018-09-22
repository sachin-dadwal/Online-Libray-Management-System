
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
	
		String message = (String) request.getAttribute("message");
		if(message!=null)
		{%>
		<font color='yellow'>
		<h1><%=message%></h1>
		</font>
		<%}
	%>
	<div class="agile-login">
		<h1>Return Book</h1>
		<div class="wrapper">
			<!--  <h2>Return Book</h2> -->
			<div class="w3ls-form">
			<form action="ReturnBookController" method="post">
<div align="left">
<pre>
<h2><font color='yellow'>Enter the book ID you want to return</font></h2>
<br>
 <td><h2><b>Book ID:</b></h2><h2><input type="text" name="BookID"></h2></td>
&nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" name="SearchBook"> &nbsp;  
 <input type="reset" name="Reset"> 
</pre>
</form>
</div>
</div>
</div>
	</div>			
	<%-- 	<%
			/* List<BookDTO> book = (List<BookDTO>) request.getAttribute("Books"); */
			
			<%-- if (book != null)
			{%>
				
<div align="left" height=200px width=100px>
<table border=5>
			<%
				for (BookDTO Book : book) {
			%>

				<td><img alt="" src="http://localhost:8080/Library_MGT_V1/images/upload/<%=Book.getBookName()%>.jpg"  width=120px height=150px>&nbsp;&nbsp;</td>
				<td><h2><b>BookID:</b></h2><h2><%=Book.getBookID()%></h2></td>
								

				<td><h2>BookName:</h2><h2><%=Book.getBookName()%></h2></td>
					
				

				<td><h2>Author:</h2><h2><%=Book.getAuthor()%></h2></td>

				<td><h2>Publisher:</h2><h2><%=Book.getPublisher()%></h2></td>

				<td><h2>Price:</h2><h2><%=Book.getPrice()%></h2></td>

				<td><h2>Quantity:</h2><h2><%=Book.getQuantity()%></h2></td>

				<td><h2>Categary:</h2><h2><%=Book.getCategary()%></h2></td>
				</td>

				<td>
				</div>
							
					<form action="BorrowBookController" method="post">
						<input type="hidden" name=bookId value=<%=Book.getBookID()%>><input
							type="submit" value="borrow">
					</form>

</td> 
			 --%>	
					
 

<footer>
<br><br><br><br><br><br><br><br>

<div class="copyright">
		<p>© 2017 Winter Login. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	</footer>
</div>
</body>
</html>









	