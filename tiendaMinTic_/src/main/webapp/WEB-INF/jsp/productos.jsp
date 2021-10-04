<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda-productos</title>
<link href="<c:url value="/static/css/style_usu.css"/>" rel="stylesheet" type="text/css">   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/productos.js"> </script>

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
  <form enctype = "multipart/form-data" id="FormProdu">
   <div>
    <input class="controls-file" type="text" name="Nombre_del_archivo" id="IdArchivo" placeholder="Nombre del archivo">
    
    <input style="display:none" type="file" name="file_name" class="upload_file invisible" id="IdSelArchivo" accept=".csv"> 
    <button type="button" class="upload_btn">Explorar</button>
   </div>
   <div class="upload-response">
    	<div id="singleFileUploadError"></div>
    	<div id="singleFileUploadSuccess"></div>
    </div>
     
    <div class=botones>
    	<input class="botons" type="submit" name="Cargar" id="cargaDocu" value="cargar">
    </div>
    </form>
    

  </section>

</body>
</html>