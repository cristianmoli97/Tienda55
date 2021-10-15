<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores Formulario</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/proveedoresform.js"> </script>
</head>
<body>
	<nav>
		<ul>
			<li><a href="usuarioscrud">Usuarios</a>
			<li><a href="clientecrud">Clientes</a></li>
			<li><a href="proveedorescrud">Proveedores</a></li>
			<li><a href="producto">Productos</a>
				<ul>
					  <li><a href="prodcrud">CRUD</a></li>
				  </ul>
			  </li>
			<li><a href="/ventas">Ventas</a></li>
			<li><a href="/reportesall">Reportes</a></li>
			<li><a href="/login">logout</a></li>
			
		</ul>
	</nav>

<section class="form-register">
  <form:form action="registrarproveedorform" method="POST" modelAttribute="proveedor" id="proveForm"> 
    <h4>Seleccione la operaci�n a realizar:</h4>    
    <div class=botones>
    	<button class="botons" id="btn_consultar" type="button">Consultar</button>
    	<button class="botons"  id="btn_crear" type="button">Crear</button>
    	<button class="botons"  id="btn_actualizar" type="button">Actualizar</button>
    	<button class="botons"  id="btn_borrar"  type="button">Borrar</button>
    </div> 
    	
    <form:input class="controls" type="text" path="nitProveedor" name="nitProveedor" id="nitProveedor" pattern="[0-9]{1,10}" placeholder="nit Proveedor" required="required"/>
    <form:input class="controls" type="text" path="ciudadProveedor" name="ciudadProveedor" id="ciudadProveedor" placeholder="ciudad Proveedor"/>
    <form:input class="controls" type="text" path="direccionProveedor" name="direccionProveedor" id="direccionProveedor" placeholder="direccion Proveedor"/>
    <form:input class="controls" type="text" path="nombreProveedor" name="nombreProveedor" id="nombreProveedor" placeholder="nombre Proveedor"/>
    <form:input class="controls" type="text" path="telefonoProveedor" name="telefonoProveedor" id="telefonoProveedor"  placeholder="telefono Proveedor"/>

    
    <div id="tabla" style="position: absolute; left: 25%; top: 35%; visibility: ${tableActive};">
 
    <table border="1" class="styled-table">
    
            <thead>
                <tr>
                    <th>nitProveedor</th>
                    <th>ciudadProveedor</th>
                    <th>direccionProveedor</th>
                    <th>nombreProveedor</th>
                    <th>telefonoProveedor</th>
                    
                </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${listaproveedores}">                
                <tr>
                    <td>${f.getNitProveedor()}</td>
                    <td>${f.getCiudadProveedor()}</td>                    
                    <td>${f.getDireccionProveedor()}</td>
                    <td>${f.getNombreProveedor()}</td>
                    <td>${f.getTelefonoProveedor()}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>

    
    </div>
    
    <div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="btn_aceptar" name="evento_boton_crud_proveedor" style="visibility:hidden" />
    	
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