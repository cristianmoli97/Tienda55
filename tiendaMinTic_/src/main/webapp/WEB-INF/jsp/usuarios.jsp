<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Usuarios </title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/usuarios.js"> </script>

</head>
<body>
<nav>
	<ul>
		<li><a href="usuario">Usuarios</a>
		<ul>
      			<li><a href="usuarioscrud">CRUD</a></li>
      		</ul>
		<li><a href="#">Clientes</a></li>
		<li><a href="#">Proveedores</a></li>
		<li><a href="#">Productos</a>
		<li><a href="#">Ventas</a></li>
		<li><a href="#">Reportes</a></li>
		<li><a href="/login">logout</a></li>
		
	</ul>
</nav>
    <div class=botones>
    	<input class="botons" type="submit" name="Cargar" id="cargaDocu" value="cargar">
    </div>
	


</body>
</html>
