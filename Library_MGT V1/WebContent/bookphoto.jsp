<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Picture</title>
</head>
<body>
<div align="center">
<a href="AdminHome.jsp">Home</a>
<h1>Upload the image</h1>
<%
String message=(String)request.getAttribute("message");
if(message!=null)
{%>
<h1><%=message %></h1>	
<%}

%>
<br>
<form action="UploadBookPhotoController" method="post" enctype="multipart/form-data">
<input type="file" name="photo"/>
<button>Upload</button>



</form>
</div>
</body>
</html>