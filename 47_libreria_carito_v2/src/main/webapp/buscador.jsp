<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<center>
		Seleccione Tema:
		<select id="temaSel" >
			<option value="0">-Todos-</option>
			<c:forEach var="t" items="${requestScope.temas}">
				<option value="${t.idTema}">${t.tema}</option>
			</c:forEach>
			
		</select>
		<br><br>
		<div id="tbLibros">
            <table id="tablaLibros" border="1" width="100%" cellspacing="0">

            </table>
		</div> 
		<h2>Carrito</h2>      
	</center>
    <script type="text/javascript">
        $("#temaSel").change(function(){
			var url="FrontController";
			var params={"operation":"doBuscar","idTema":$("#temaSel").val()};
			gestionarPeticion(url,params);
		});

        function gestionarPeticion(url,params){
		$.get(url,params,function(data){
			let tablaLibros = "<thead><tr><th width=\"10\">Título</th><th width=\"10\">Precio</th><th width=\"10\">Páginas</th></tr></thead><tbody>";
				//recorremos JSON de respuesta y creamos una entrada HTML por cada resultado
				$.each(data,function(i,e){
					tablaLibros += "<tr><td style='text-align: center;'>" + e.titulo + "</td>";
                    tablaLibros += "<td style='text-align: center;'>" + e.precio + "</td>";
                    tablaLibros += "<td style='text-align: center;'>" + e.paginas + "</td>";
                    tablaLibros += "</tr>";
				});
				tablaLibros += "</tbody>";
				//volcamos el html completo en el div
				$("#tablaLibros").html(tablaLibros)
		});
	}
    </script>
    </body>
    </html>