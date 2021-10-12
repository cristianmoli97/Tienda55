<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <form:form action="registrarusuarioform"  method="post" modelAttribute="usuario" id="usuariosForm"> 
    <h4>Seleccione operacion a realizar:</h4>
    <div class=botones>
    	<button class="botons" id="btn_consultar" type="button">Consultar</button>
    	<button class="botons"  id="btn_crear" type="button">Crear</button>
    	<button class="botons"  id="btn_actualizar" type="button">Actualizar</button>
    	<button class="botons"  id="btn_borrar"  type="button">Borrar</button>
    </div>

    <form:input class="controls" type="text" path="Cedula" name="Cedula" id="Cedula" pattern="[0-9]{1,12}" placeholder="Cedula" required="required" />
    <form:input class="controls" type="text" path="usuario" name="usuario" id="usuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="usuario"/>
    <form:input class="controls" type="text" path="passwordUsuario" name="passwordUsuario" id="passwordUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="passwordUsuario"/>
    <form:input class="controls" type="text" path="nombreUsuario" name="nombreUsuario" id="nombreUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="nombreUsuario"/>
    <form:input class="controls" type="text" path="correoUsuario" name="correoUsuario" id="correoUsuario" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="correoUsuario"/>
    <div id="tabla" style="position: absolute; left: 25%; top: 35%; visibility: ${tableActive};">
  <table border="1" class="styled-table">
    
            <thead>
                <tr>
                    <th>cedula</th>
                    <th>usuario</th>
                    <th>passworUsuario</th>
                    <th>nombreUsuario</th>
                    <th>emailUsuario</th>
                 </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${listausuario}">                
                <tr>
                    <td>${f.getCedula()}</td>
                    <td>${f.getUsuario()}</td>
                    <td>${f.getPasswordUsuario()}</td>
                    <td>${f.getNombreUsuario()}</td>
                    <td>${f.getCorreoUsuario()}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    </div>
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
