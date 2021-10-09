<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes Formulario</title>
<link href="proveedores.css" rel="stylesheet" type="text/css">  
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



<div class="contenedor">

<form:form action="registerCliente" method="post" modelAttribute="cliente">
            <form:label  path="cedulaCliente">cedula cliente</form:label>
            <form:input path="cedulaCliente" placeholder="cedula cliente"/><br/>
             
            <form:label path="nombreCompleto">Nombre completo:</form:label>
            <form:input path="nombreCompleto" placeholder=" nombre completo"/><br/>
             
            <form:label path="direccion">direccion:</form:label>
            <form:input path="direccion" placeholder=" direccion"/><br/> 

             <form:label path="telefono" >telefono:</form:label>
            <form:input path="telefono" placeholder="telefono"/><br/>  

             <form:label path="correoElectronico">correo electronico:</form:label>
            <form:input path="correoElectronico" placeholder="correo electronico"/><br/>   
                 
            <form:button>Enviar</form:button>

</div>

<div class="botones">
<input class="botons" type="submit" name="evento_boton_crud_cliente" value="Consultar">
    	<input class="botons" type="submit" name="evento_boton_crud_cliente" value="Crear">
    	<input class="botons" type="submit" name="evento_boton_crud_cliente" value="Actualizar">
    	<input class="botons" type="submit" name="evento_boton_crud_cliente" value="Borrar">
        <input class="botons" type="submit" name="evento_boton_crud_cliente" value="Listar">

</div>
<div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="prodcrud" id="close-button2">Aceptar</a></div>
    	</div>
	</div>

</div>


</body>


</html>
