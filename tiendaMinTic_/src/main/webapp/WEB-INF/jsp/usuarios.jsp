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
	<div>
       		<h2>Registro exitoso</h2>
        	<span>Cedula:</span><span>${user.cedula_usuario)</span><br/>
        	<span>Nombre:</span><span>${user.nombre_usuario}</span><br/>
        	<span>Correo:</span><span>${user.email_usuario}</span><br/>
        	<span>Usuario:</span><span>${user.usuario</span><br/>
		<span>Password:</span><span>${user.password</span><br/>
	    </div>
	


</body>
</html>
