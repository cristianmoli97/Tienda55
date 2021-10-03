<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>productorForm</title>
<link href="<c:url value="/static/css/style_usu.css"/>" rel="stylesheet" type="text/css">    


</head>
<body>
<nav>
	<ul>
		<li><a href="#">Usuarios</a>
		<li><a href="#">Clientes</a></li>
		<li><a href="#">Proveedores</a></li>
		<li><a href="<c:url value="producto"/>">Productos</a>
			<ul>
      			<li><a href="<c:url value="prodcrud"/>">CRUD</a></li>
      		</ul>
      	</li>
		<li><a href="#">Ventas</a></li>
		<li><a href="#">Reportes</a></li>
		<li><a href="<c:url value="/login"/>">logout</a></li>
		
	</ul>
</nav>


  <section class="form-register">
  <form:form action="registrarproductoform" method="POST" modelAttribute="producto"> 
    <h4>Ingrese:</h4>
    <div>
    	<label for="codigoProducto">codigoProducto</label>
    	<form:input class="controls" type="text" path="codigoProducto" name="codigoProducto" id="codigoProducto" placeholder="codigo Producto"/>
    	<div class="has-error">
        	<form:errors path="codigoProducto" class="help-inline"/>
    	</div>
    </div>
    
    <form:input class="controls" type="text" path="ivaCompra" name="ivaCompra" id="ivaCompra" placeholder="iva Compra"/>
    <form:input class="controls" type="nitProveedor" path="nitProveedor" name="nitProveedor" id="nitProveedor" placeholder="nit Proveedor"/>
    <form:input class="controls" type="text" path="nombreProducto" name="nombreProducto" id="nombreProducto" placeholder="nombre Producto"/>
    <form:input class="controls" type="text" path="precioCompra" name="precioCompra" id="precioCompra" placeholder="precio Compra"/>
    <form:input class="controls" type="text" path="precioVenta" name="precioVenta" id="precioVenta" placeholder="precio Venta"/>
    <div class=botones>
    	<input class="botons" type="submit" id="consultar" name="evento_boton_crud_producto" value="Consultar">
    	<input class="botons" type="submit" name="evento_boton_crud_producto" value="Crear">
    	<input class="botons" type="submit" name="evento_boton_crud_producto" value="Actualizar">
    	<input class="botons" type="submit" name="evento_boton_crud_producto" value="Borrar">
    </div>
  </form:form>
  </section>
  <div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="<c:url value="prodcrud"/>" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>

</body>
</html>