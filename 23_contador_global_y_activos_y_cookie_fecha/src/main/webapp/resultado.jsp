<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int contador=(Integer)session.getAttribute("contador");
	int global=(Integer)application.getAttribute("global");
	int activos=(Integer)application.getAttribute("activos");%>
	<center>
		<h1>Has entrado <%=contador%> veces</h1>
		<h2>Total de visitantes <%=global%> </h2>
		<h2>Usuario activos <%=activos%> </h2>
		<%String fecha="";
		//Objeto array con todas las cookies del usuario
		 Cookie todas[]=request.getCookies();
		 if(todas!=null){
		 	for(Cookie ck:todas){//Recorrer el array
		 		if(ck.getName().equals("fechaVisita")){//Busar cookie concreta a través de su referencia
		 			fecha=ck.getValue();//Variable q guarda el valor de la cookie(fecha)
		 		}
		 	}
		 }%>		
		<h2>Fecha de su última visita: <%=fecha%></h2>
		<br>
		<a href="entrada.html">Volver</a>
	</center>
</body>
</html>