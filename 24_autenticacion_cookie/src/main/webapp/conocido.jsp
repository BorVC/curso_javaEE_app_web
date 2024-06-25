<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%String datosUsu = "";
       Cookie todas[] = request.getCookies();
       for(Cookie ck : todas){
    	   if(ck.getName().equals("usuarioVisita")){
    		   datosUsu = ck.getValue();
    	   }
       }
     %>
     <h2>Bienvenido: <%=datosUsu%></h2>
		<br>
		<a href="login.html">Volver</a>
</body>
</html>