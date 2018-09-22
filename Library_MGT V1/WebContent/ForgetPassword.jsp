<html>
<body>
<div align="center">

<h1>Enter the details</h1>
<a href="index.html"><button>Login</button></a>
<h2>Forget Password</h2>
<%
String message=(String)request.getAttribute("message");
System.out.println(message);

if(message!=null)
{%>
<h1><%=message%></h1>
<%}
%>
<form action="ForgetController" method="get">
UserName:<input type="text"  name="UserName" required/><br><br>
Email:<input type="text" name="Email" required/><br><br>
<input type="submit" value="Submit"/> &nbsp;&nbsp;<input type="reset" value="Reset"/>


</form>
</div>



</body>
</html>