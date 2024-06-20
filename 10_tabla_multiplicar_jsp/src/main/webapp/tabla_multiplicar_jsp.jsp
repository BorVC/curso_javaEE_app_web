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
      <table border = '1'>
         <%//genera 10 filas  %>
         <%for (int i = 1; i<=10; i++){ %>
            <tr>
            <%//Genera 10 celdas en cada fila con el resultado de las tablas de multiplicar del 1 al 10 %>
            <%for(int j = 1;j <= 10;j++){%>
                <td><%= i * j %></td>
            <%}%>
            </tr>
         <%}%>
      </table>       
   </center>
   
</body>
</html>