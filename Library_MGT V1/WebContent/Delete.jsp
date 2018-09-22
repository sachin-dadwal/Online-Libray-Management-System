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
	<!--stylesheets-->
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

 <body style="background-image:url('http://localhost:8080/Library_MGT_V1/images/e6c4e2b1-30b9-4c48-8c81-bcd87ef31b20_6.jpg')">   
<!--  <body> --> 

<div class="navbar">
  <b><a href="Home1.jsp">Home</a></b>
  <a href="Register.jsp">Register</a>
  <a href="AdminSelectAllBookController">All Available Books</a>
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
<% 


String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<h1>welcome</h1>
	
<%}
%>

<div class="agile-login">
		<h1>Enter the User Details</h1>
		<div class="wrapper">
			<h2>Delete User</h2>
			<div class="w3ls-form">
<form action="DeleteController" method="get">
<pre>

<!-- <h3>Enter the details to register the user</h3> -->

<!-- <h3>UserName:<input type="text" name="UserName"><br></h3> -->

	<label>UserName</label>
					<input type="text" name="UserName" placeholder="UserName" required/>
	<!-- <label>Password</label>
					<input type="text" name="Password" placeholder="Password" required/>
	<label>Mobile</label>
					<input type="text" name="Mobile" placeholder="Mobile" required/>
	<label>Email</label>
					<input type="text" name="Email" placeholder="Email" required/>
	<label>Address</label>
					<input type="text" name="Address" placeholder="Address" required/>	 -->		

&nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" name="Delete"> &nbsp; 
 <!-- <input type="reset" name="Reset"> -->

</pre>


</form>
</div>
 
 
</div>

<div class="copyright">
		<p>© 2017 Winter Login. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	



</body>
</html>
