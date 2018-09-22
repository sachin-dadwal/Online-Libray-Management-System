<!DOCTYPE html>

<html>
<div class="agile-login" align="center">
<h1>Welcome to Oxford Liberary</h1>
</div>
<%
response.setHeader("Cache-Control", "no-cache,no-store,private,must-reavalidate,max-stale=0,post-check=0,pre-check=0");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires","0");%>
<head>

<meta charset="utf-8">
 	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	stylesheets-->
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
<%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="DTO.BookDTO"%>

 <body style="background-image:url('http://localhost:8080/Library_MGT_V1/images/e6c4e2b1-30b9-.jpg')">   
<!--  <body> --> 

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
</div>


<!-- <h3>Dropdown Menu inside a Navigation Bar</h3>
<p>Hover over the "Dropdown" link to see the dropdown menu.</p> -->
<div class="Block-body">
<div class="BlockHeader">
<div class="header-tag-icon">
<div align="right">
<button onclick= "myFunction()"><h1><a href="LogoutServlet"><font color='black'>LOGOUT</font></a></button></h1>
<div align="left">
<a href="photo.jsp"><button><h1>Upload photo</h1></button></a>
</div>

<%
String UserName=(String)request.getAttribute("UserName");
if(UserName!=null)
{%>
<h1><font color='white'>Welcome, <%=UserName%>&nbsp;&nbsp;&nbsp;&nbsp;</font></h1>
<img alt="Upload user photo" src="http://localhost:8080/Library_MGT_V1/images/upload/<%=UserName%>.jpg"  width=120px height=150px>&nbsp;&nbsp;
<!-- <img alt="" src="http://localhost:8080/Library_MGT_V1/images/upload/test.jpg" width=120px height=150px>&nbsp;&nbsp; -->
<%}
%>
 </div>
<script>
function myFunction() {
alert("You are Logout");
}
</script>
</div>
</div>
</div>

<div align="left">					
		<h2><u><mark>Recently added Book</mark></u></h2>
		
    
   <%
List<BookDTO> book = (List<BookDTO>) request.getAttribute("Books");
   
String message = (String) request.getAttribute("message");
		
	%>
	
			
			<div class="w3ls-form">
							
		<%
						
			if (book != null)
			{%>
				

<table border="0" align="center" cellpadding="1" cellspacing="1">
<tbody>
<tr>
			<%
				for (BookDTO Book : book) {
			%>
			

<h3><a href="SelectAllBookController"><div align="center"><font color='white'><%=Book.getBookName()%></font></div></a></h3>

				</tr>
				

				
			<%
				}
			%>


			<%
				}
			%>

</tbody>
			</table>
		
					</div>
					</div>
				
		
		
		
		
				
					<div align="center">
<table width="948" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td><a href="Register.jsp" class="image"><img src="images/approveuser.png" alt="" height=150px width=120px><h2><b>Register</b></h2></a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="BorrowBook.jsp" class="image"><img src="images/borrow_book1600.png" alt="" height=150px width=120px><h2><b>Borrow</b></h2></a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<tr>
&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td><a href="SearchBook.jsp" class="image"><img src="images/book_view.png" alt="" height=150px width=120px><h2><b>Search</b></h2></a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;<td><a href="BuyBook.jsp" class="image"><img src="images/buybook.png" alt="" height=150px width=120px><h2><b>Buy</b></h2></a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<tr>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td><a href="SelectAllBookController" class="image"><img src="images/book_view.png" alt="" height=150px width=120px><h2><b>View All</b></h2></a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="ReturnBook.jsp" class="image"><img src="images/return.png" alt="" height=150px width=120px><h2><b>Return</b></h2></a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;

</tr></tr>




	</tr>
	</table>
	



 </div>
 </font>

 
</div>
			
										<br>
										<br>

		<!-- One -->
		

<div class="copyright">
		<p>© 2017 Winter Login. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	




</body>
</html>
