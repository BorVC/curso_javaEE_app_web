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
    <h2>URL: ${requestScope.resultado.url }</h2>
	<h2>Temática: ${requestScope.resultado.tematica }</h2>
	<h2>Descripción: ${requestScope.resultado.descripcion }</h2>
	<a href="FrontController?operation=toInicio">Volver a home</a>  
    </center>
    
</body>
</html>