<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" "%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <center>
    <c:forEach var = "r" items ="${requestScope.resultado">
    
    <h2>URL: ${r.resultado.url }</h2>
	<h2>Temática: ${r.resultado.tematica }</h2>
	<h2>Descripción: ${r.resultado.descripcion }</h2>
	
	</c:forEach>
	<a href="FrontController?operation=toInicio">Volver a home</a>  
    </center>
    
</body>
</html>