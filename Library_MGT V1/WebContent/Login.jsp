<html>
<div align="center">
<header><h1><b>Welcome to Oxford Liberary</b></h1></header>

<body>

<%

String message=(String)request.getAttribute("message");
if(message!=null)
 {%>
<h1><%=message%></h1>
	
<%}%>
<pre>
<form action="LoginController" method="post">
				<h2>All the Books in one place...!</h2>
				<h3> Please Sign in to continue</h3>
					
UserName: <input type="text" name="username" placeholder="Username" required>
 &nbsp; 
Password: <input type="password" name="password" placeholder="Password" required >

<br>
<input type="submit" name="submit"> &nbsp;  &nbsp;  <input type="reset" name="reset">

<h2><a href="Register.jsp">Register </a><br></h2> 
<footer>
<h1>new learning experience !!!!</h1>
<p>Copyright@NewAgeTechnologiesLimited.com</p>

                    <ul class="copyright">
						<li>&copy; Untitled.</li>
						<li>Images: <a href="http://unsplash.com">Unsplash</a>.</li>
						<li>Design: <a href="http://templated.co">TEMPLATED</a>.</li>
					</ul>
</footer>
</form>
</pre>



</div>
</body>


</html>