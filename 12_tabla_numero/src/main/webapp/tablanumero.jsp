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
   <tittle><h2>Tabla de multiplicar del número <%=request.getParameter("numero") %></h2></tittle>
      <table border="1">
          <%for(int i=1; i<=10;i++){ %>
              <tr>
                 <td><%=request.getParameter("numero") %> x  <%=i %></td>
                 <td><%=Integer.parseInt(request.getParameter("numero")) * i %></td>
              </tr>
          <%} %>
      </table> 
      </br>
      <a href='numero.html'>Volver<a>
   </center>
   
</body>
</html>