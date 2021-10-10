<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores Formulario</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<nav>
		<ul>
			<li><a href="usuarioscrud">Usuarios</a>
			<li><a href="clienteForm">Clientes</a></li>
			<li><a href="proveedorescrud">Proveedores</a></li>
			<li><a href="producto">Productos</a>
				<ul>
					  <li><a href="prodcrud">CRUD</a></li>
				  </ul>
			  </li>
			<li><a href="#">Ventas</a></li>
			<li><a href="/reportesall">Reportes</a></li>
			<li><a href="/login">logout</a></li>
			
		</ul>
	</nav>

<section class="form-register">
  <form:form action="registrarproveedorform" method="POST" modelAttribute="proveedor"> 
    <h4>Ingrese:</h4>   
    	
    <form:input type="text" path="nitProveedor" name="nitProveedor" id="nitProveedor" placeholder="nit Proveedor"/>
    <form:input type="text" path="ciudadProveedor" name="ciudadProveedor" id="ciudadProveedor" placeholder="ciudad Proveedor"/>
    <form:input type="text" path="direccionProveedor" name="direccionProveedor" id="direccionProveedor" placeholder="direccion Proveedor"/>
    <form:input type="text" path="nombreProveedor" name="nombreProveedor" id="nombreProveedor" placeholder="nombre Proveedor"/>
    <form:input type="text" path="telefonoProveedor" name="telefonoProveedor" id="telefonoProveedor" placeholder="telefono Proveedor"/>

    <div class=botones>
    	<input class="botons" type="submit" id="consultar" name="evento_boton_crud_proveedor" value="Consultar">
    	<input class="botons" type="submit" name="evento_boton_crud_proveedor" value="Crear">
    	<input class="botons" type="submit" name="evento_boton_crud_proveedor" value="Actualizar">
    	<input class="botons" type="submit" name="evento_boton_crud_proveedor" value="Borrar">
    </div>
    
    </form:form>
 </section>
 
 <div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="proveedorescrud" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>



</body>
</html>