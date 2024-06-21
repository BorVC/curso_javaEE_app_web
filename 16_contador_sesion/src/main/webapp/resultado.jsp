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
      <%--Variable q guarda objeto session con la llamada al atributo de session --%>
     <%int contador = (Integer)session.getAttribute("contador"); %>
     <h2>Has entrado <%= contador %> veces</h2>
     <a href="inicio.html">Volver</a>
     </center>
</body>
</html>