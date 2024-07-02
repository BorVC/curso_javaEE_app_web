<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<title>Crear Producto</title>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple; input { display : block;
	margin-bottom: 15px;
}

input {
	color: purple;
	margin: 0 auto; 
	display : block;
	margin-bottom: 15px;
	border: 1px solid purple;
	padding: 7px;
	display: block;
}}
</style>
</head>
<body>
	<div>
		<h1>A�adir nuevo curso</h1>
		<form action="FrontController?operation=doGuardar" onsubmit="return validar();" method="post">
			Nombre curso:<input type="text" id="nombre" name="nombre" placeholder="Nombre del curso"><br>
			Tem�tia del curso:<input type="text" id="tematica" name="tematica" placeholder="T�m�tica del curso" ><br>
			Duraci�n curso:<input type="text" id="duracion" name="duracion" placeholder="Duraci�n del curso"> <br>
			Precio curso:<input type="text" id="precio" name="precio" placeholder="Precio del curso"> <br>
			<input type="submit" value="Guardar">
		</form>
		<br>
		<br>
		<h2>${requestScope.mensaje}</h2>
		<a href="FrontController?operation=toMenu">Volver</a>
	</div>
	<script>
		function validar(){
			let nombre = document.getElementById("nombre").value;
			let tematica = document.getElementById("tematica").value;
			let duracion = document.getElementById("duracion").value;
			let precio = document.getElementById("precio").value;

			if(nombre.trim().length == 0){
				alert("Has de introducir un nombre para el curso");
				return false;
			}
			if(!tematica.startsWith('P',0) && !tematica.startsWith('W',0) && !tematica.startsWith('S',0)){
				alert("La temática del curso solo puede comenzar por las letra 'P','W' o 'S'");
				return false;
			}
			if(isNaN(duracion) || (duracion <30 || duracion > 200)){
				alert("La duración del curso no puede ser menor de 30 ni mayor de 200");
				return false;
			}
			if(precio.trim().length==0||isNaN(precio)||precio<0){
				alert("precio no válido");
				return false;
			}
			alert("Datos correctos!!!")
			return true;
		}
	</script>
	
</body>
</html>