<<!DOCTYPE html>

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

<!-- <body style="background-image:url('http://localhost:8080/Library_MGT_V1/images/e6c4e2b1-30b9-4c48-8c81-bcd87ef31b20_6.jpg')"> --> 
<body>

<div class="navbar">
  <b><a href="AdminHome.jsp">Home</a></b>
  	<a href="AddBook.jsp">Add Book</a>
   	<a href="DeleteBook.jsp">Remove Book</a>
   	<a href="UpdateBook.jsp">Update Book</a>
   <a href="AdminSelectAllBookController">All Available Books</a>
    <a href="ISActive.jsp">Activate  Borrow</a>
    <a href="Activate_Status.jsp">Activate Purchase</a>
      
     
  <div class="dropdown">
    <button class="dropbtn">Search Book
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="adminSearchBookName.jsp">Search BookName</a>
      <a href="adminSearchBookAuthor.jsp">Search Author</a>
      <a href="adminBookPublication.jsp">Search Publication</a>
      <a href="adminSearchBookPrice.jsp">Search Price</a>
    </div>
  </div> 

</div>
<div align="right">
<button onclick= "myFunction()"><a href="LogoutServlet"><b><mark>LogOut</mark></b></a></button>
<script>

function myFunction() {
    alert("You are Logged out");
}
</script>
</div>
<!-- <h3>Dropdown Menu inside a Navigation Bar</h3>
<p>Hover over the "Dropdown" link to see the dropdown menu.</p> -->
<div align="center">

<h1><font color="red">Welcome Administrator</font></h1>
<p><font color="red">Please choose the option</font></p>

<br>
<br>
<!-- 
<div class="image-grid">
<br>
<br>
<a href="Register.jsp" class="image"><img src="images/approveuser.png" alt="" height=150px width=120px><h2><font color='black'>Register User</font></h2></a>
<a href="AddBook.jsp" class="image"><img src="images/new-address-book-icon-44606.png" alt="" height=150px  width=120px /><h2><font color='black'>Add Book</font></h2></a><br>
 <a href="adminSearchBook.jsp" class="image"><img src="images/book_view.png" alt=""  height=150px width=120px/><h2><font color='black'>Search Book</font></h2></a><br>
<a href="DeleteBook.jsp"><img src="images/delete--address-book-icon-44607.png" alt=""/ height=150px width=120px><h2><font color='black'>Delete Book</font></h2></a><br>
<a href="UpdateBook.jsp"><img src="images/edit--address-book-icon-44608.png" alt="" height=150px width=120px/><h2><font color='black'>Update Book</font></h2></a><br>
<br>
<a href="SelectAllBookController" class="image"><img src="images/book_view.png" alt="" height=150px width=120px/><h2><font color='black'>All Available Books</font></h2> </a>
<a href="Activate_Status.jsp" class="image"><img src="images/request-512.png" alt="" height=150px width=120px/><h2><font color='black'>Activate Purchase</font></h2></a>
<a href="ISActive.jsp" class="image"><img src="images/78838-200.png" alt="" height=150px width=120px/><h2><font color='black'>Activate Borrow</font></h2></a>
 <br><br>
<a href="#" class="image"><img src="images/allrequest.png" alt="" height=150px width=120px/><h2><font color='black'>Manage Users</font></h2></a>
						
						

<footer>
<br><br><br><br><br><br><br><br>

<div class="copyright">
		<p>© 2017 Winter Login. All rights reserved | Design by <a href="www.w3layouts.com">W3layouts</a></p> 
	</div>
	</footer>
</div> -->


<div align="center">
<table width="948" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>


<!-- <td><a href="Register.jsp" class="image"><img src="images/approveuser.png" alt="" height=150px width=120px><h2><b>Aproove User</b></h2></a></td> -->

<td><a href="AddBook.jsp" class="image"><img src="images/new-address-book-icon-44606.png" alt="" height=150px  width=120px /><h2><b>Add Book</b></h2></a></td>
<td><a href="adminSearchBook.jsp" class="image"><img src="images/book_view.png" alt=""  height=150px width=120px/><h2><b>Search Book</b></h2></a></td>
<tr>


<td><a href="DeleteBook.jsp"><img src="images/delete--address-book-icon-44607.png" alt=""/ height=150px width=120px><h2><b>Delete Book</b></h2></a><br></td>

<td><a href="UpdateBook.jsp"><img src="images/edit--address-book-icon-44608.png" alt="" height=150px width=120px/><h2><b>Update Book</b></h2></a><br></td>

<td><a href="AdminSelectAllBookController" class="image"><img src="images/book_view.png" alt="" height=150px width=120px/><h2><b>All Available Books</b></h2> </a></td>

<tr>


<td><a href="Activate_Status.jsp" class="image"><img src="images/request-512.png" alt="" height=150px width=120px/><h2><b>Activate Purchase</b></h2></a></td>
<td><a href="ISActive.jsp" class="image"><img src="images/78838-200.png" alt="" height=150px width=120px/><h2><b>Activate Borrow</b></h2></a></td>
<td><a href="AdminHome.jsp" class="image"><img src="images/allrequest.png" alt="" height=150px width=120px/><h2><b>Manage Users</b></h2></a></td>

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
