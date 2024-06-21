<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Producto,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <center>
         <table border="1">
            <th>Nombre</th>
            <th>Precio</th>
            <th>Categoria</th>
            <th> </th> 
            <%List<Producto> productos = (List<Producto>) session.getAttribute("carrito"); 
                for(Producto producto : productos){%>
                <tr>
                   <td><%=producto.getNombre() %></td>
                   <td><%=producto.getPrecio() %></td>
                   <td><%=producto.getCategoria() %></td>
                   <td><a href = "Eliminar?nombre=<%=producto.getNombre()%>">Eliminar</a></td>
                </tr>
                <%} %>
         </table>
         </br>
         </br>
         <a href = "index.html">Volver</a>
     </center>
</body>
</html>