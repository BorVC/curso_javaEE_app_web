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
       <c:chose>
         
              <h2>Productos de ${param.categoria}</h2>
              <table border="1">
                 <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                 </tr>
                 <c:forEach var = "pr" items="${requestScope.productosPorCategoria }"> 
                   <tr>
        	          <td>${pr.nombre}</td>
        	          <td>${pr.precio}></td>
        	      </tr>
                 </c:forEach>
 
       </c:chose>
    </table>
    <a href="gestorProductos.html">Volver a home</a>  
    </center>
    
</body>
</html>