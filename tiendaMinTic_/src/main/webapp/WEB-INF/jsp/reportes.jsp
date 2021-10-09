<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>reportes</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/reportes.js"> </script>


</head>
<body>
<nav>
	<ul>
		<li><a href="#">Usuarios</a>
		<li><a href="#">Clientes</a></li>
		<li><a href="#">Proveedores</a></li>
		<li><a href="producto">Productos</a>
			<ul>
      			<li><a href="prodcrud">CRUD</a></li>
      		</ul>
      	</li>
		<li><a href="#">Ventas</a></li>
		<li><a href="/reportes">Reportes</a></li>
		<li><a href="/login">logout</a></li>
		
	</ul>
</nav>


  <section class="form-register">
  <form:form action="reportesapp"  method="post" modelAttribute="producto" id="listaReportes"> 
    <h4>Seleccione operacion a realizar:</h4>
    <div class=botones>
    	<div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="list_usu" value = "listado de usuarios" name="evento_boton_reportes" style="visibility:visible" />
    	
    	</div>
    	<div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="list_clientes" value = "listado de clientes" name="evento_boton_reportes" style="visibility:visible" />
    	
    	</div>
    	<div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="List_ventas" value="ventas por cliente" name="evento_boton_reportes" style="visibility:visible" />
    	
    	</div>
    
    </div>

    <div id="tabla" style="position: absolute; left: 25%; top: 50%; visibility: ${tableActive};">
 
    <table border="1" class="styled-table">
    
            <thead>
                <tr>
                    <th>${labelcampo1}</th>
                    <th>${labelcampo2}<</th>
                    <th>${labelcampo3}<</th>
                    <th>${labelcampo4}<</th>
                    <th>${labelcampo5}<</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${listareporte}">                
                <tr>
                    <td id="repocol1">${f.getCampo1()}</td>
                    <td id="repocol2">${f.getCampo2()}</td>
                    <td id="repocol3">${f.getCampo3()}</td>
                    <td id="repocol4"  class='unselectable'>${f.getCampo4()}</td>
                    <td id="repocol5" class='unselectable'>${f.getCampo5()}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>

    
    </div>
    
  </form:form>
  </section>
  <div class="window-notice" id="window-notice" style="visibility: hidden">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="reportes" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>

</body>
</html>