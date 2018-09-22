<html>
<body>


<%

String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<h1><%=message%></h1>
	
<%}
%>
<form action="HomeController" method="get">
<h2><a href="LogoutServlet">LogOut</a></h2>
<div align="center">
<h1>Welcome user here </h1>
<h2>Please the option</h2>
<br>
<br><br><br>
<a href="Register.jsp">Register User</a><br>
<a href="BorrowBook.jsp"> Borrow Book</a><br>
<a href="SearchBook.jsp">Search the Book</a><br>
<a href="BuyBook.jsp">Buy the Book</a><br>
<a href="SelectAllBookController">Display all the book </a><br>
<a href="ReturnBook.jsp">Return the book</a><br>

</div>
</form>
</body>

</html>