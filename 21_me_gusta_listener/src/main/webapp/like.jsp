<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <center>
	<img src="tigre.jfif" width="200" height="200" border="2px"><br><br>
	<h2>¿TE GUSTA LA FOTO?</h2>
	<h2>
	<a href="ContadorLikes?opcion=megusta">
		&#128077;
	</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ContadorLikes?opcion=nomegusta">
		&#128078;
	</a>
	</h2>
	<h2>
		<%=application.getAttribute("megusta")!=null?application.getAttribute("megusta"):0%>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<%=application.getAttribute("nomegusta")!=null?application.getAttribute("nomegusta"):0%>
	</h2>
	</center>
</body>
</html>