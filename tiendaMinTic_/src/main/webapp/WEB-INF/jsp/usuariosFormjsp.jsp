<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>usuariosForm</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/usuariosform.js"> </script>

</head>
<body>
<nav>
	<ul>
		<li><a href="usuario">Usuarios</a>
			<ul>
      			<li><a href="usuarioscrud">CRUD</a></li>
      		</ul>
		<li><a href="#">Clientes</a>
		<li><a href="#">Proveedores</a></li>
		<li><a href="#">Productos</a></li>
		<li><a href="#">Ventas</a></li>
		<li><a href="#">Reportes</a></li>
		<li><a href="/login">logout</a></li>
	</ul>
</nav>

  <section class="form-register">
  <form:form action="registrarusuarioform"  method="post" modelAttribute="usuario" id="usuarioForm"> 
    <h4>Seleccione operacion a realizar:</h4>
    <div class=botones>
    	<button class="botons" id="btn_consultar" type="button">Consultar</button>
    	<button class="botons"  id="btn_crear" type="button">Crear</button>
    	<button class="botons"  id="btn_actualizar" type="button">Actualizar</button>
    	<button class="botons"  id="btn_borrar"  type="button">Borrar</button>
    </div>

    <form:input class="controls" type="text" path="cedula" name="cedula" id="cedula" pattern="[0-9]{1,12}" placeholder="cedula" required="required" />
    <form:input class="controls" type="text" path="usuario" name="usuario" id="usuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="usuario"/>
    <form:input class="controls" type="text" path="passwordUsuario" name="passwordUsuario" id="passwordUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="passwordUsuario"/>
    <form:input class="controls" type="text" path="nombreUsuario" name="nombreUsuario" id="nombreUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="nombreUsuario"/>
    <form:input class="controls" type="text" path="emailUsuario" name="emailUsuario" id="emailUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="emailUsuario"/>

    
    <div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="btn_aceptar" name="evento_boton_crud_usuario" style="visibility:hidden" />
    	
    </div>
  </form:form>
  </section>
  <div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="usuarioscrud" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>

</body>
</html>