
<%-- <html>


<%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="DTO.UserDTO"%>
	
<body>
<div align="center">
<form action="ForgetController1" method="post">
<%
String UserName=(String)request.getAttribute("UserName"); 




%>
<h1>Please Set up new password</h1>
<br>
<br>
<input type="text" name="UserName" value=<%=UserName %>><br>
Password<input type="text" name="password" required><br><br>
<input type="text" name="password1" required>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Submit"/> &nbsp;&nbsp;<input type="reset" name="Reset"/>



</form>
</div>
</body>
</html> --%>
<html>
<%@ page import="java.util.*"%>
	<%@ page import="javax.sql.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%@ page import="DTO.UserDTO"%>
<body>
<div align="center">

<%
String UserName=(String)request.getAttribute("UserName"); 
System.out.println(UserName);




%>
<script type="text/javascript">


  function checkForm(form)
  {
     if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
      if(!checkPassword(form.pwd1.value)) {
        alert("The password you have entered is not valid!");
        form.pwd1.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.pwd1.focus();
      return false;
    }
    return true;
  }

</script>
<a href="index.html"><button>Login</button></a>
<form method="POST" action="ForgetController1" onsubmit="return checkForm(this);">
<input type="text" name="UserName" value=<%=UserName %>><br>
<p>Password: <input type="password" name="pwd1"></p>
<p>Confirm Password: <input type="password" name="pwd2"></p>
<p><input type="submit"></p>
</form>
</div>
</body>
</html>