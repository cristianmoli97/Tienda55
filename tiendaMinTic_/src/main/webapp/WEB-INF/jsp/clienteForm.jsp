<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes Formulario</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/clientesform.js"> </script>
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
  <form:form action="registrarcliente" method="post" modelAttribute="cliente" id="clienteForm"> 
    <h4>Seleccione la operación a realizar:</h4>    
    <div class=botones>
    	<button class="botons" id="btn_consultar" type="button">Consultar</button>
    	<button class="botons"  id="btn_crear" type="button">Crear</button>
    	<button class="botons"  id="btn_actualizar" type="button">Actualizar</button>
    	<button class="botons"  id="btn_borrar"  type="button">Borrar</button>
    </div> 
    	
    <form:input class="controls" type="text" path="cedulaCliente" name="cedulaCliente" id="cedulaCliente" pattern="[0-9]{1,10}" placeholder="cedula Cliente" required="required"/>
    <form:input class="controls" type="text" path="nombreCompleto" name="nombreCompleto" id="nombreCompleto" pattern="[a-z,A-Z,0-9, ]{1,25}" placeholder="nombre completo"/>
    <form:input class="controls" type="text" path="direccion" name="direccion" id="direccion" placeholder="direccion cliente"/>
    <form:input class="controls" type="text" path="telefono" name="telefono" id="telefono" pattern="[0-9]{1,10}" placeholder="telefono "/>
    <form:input class="controls" type="text" path="correoElectronico" name="correoElectronico" id="correoElectronico"  pattern="[a-z,A-Z,0-9]{1,25}{@,.}" placeholder="correo electronico"/>

    
   <div id="tabla" class="datagrid" style=" z-index: 1;position: absolute;left: 32%; top: 35%;visibility: ${tableActive};">
    <table >
    
            <thead>
                <tr>
                    <th>cedulaCliente</th>
                    <th>nombreCompleto</th>
                    <th>direccion</th>
                    <th>telefono</th>
                    <th>CorreoElectronico</th>
                    
                </tr>
            </thead>
            <tbody>
            <tfoot>
			<tr>
				<td colspan="6" >
					<div id="paging">
					<ul>
					<li>
					<a href="#"><span>Previous</span></a>
					</li>
					<li>
					<a href="#" class="active">	<span>1</span></a>
					</li>
					<li>
					<a href="#"> <span>2</span></a>
					</li>
					<li>
					<a href="#"><span>Next</span></a>
					</li>
					</ul>
					</div>
			</tr>
		</tfoot>
            <c:forEach var="f" items="${listacliente}">                
                <tr>
                    <td>${f.getCedulaCliente()}</td>
                    <td>${f.getNombreCompleto()}</td>                    
                    <td>${f.getDireccion()}</td>
                    <td>${f.getTelefono()}</td>
                    <td>${f.getCorreoElectronico()}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>

    
    </div>
    
    <div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="btn_aceptar" name="evento_boton_crud_cliente" style="visibility:hidden" />
    	
    </div>
    
    
    
    </form:form>
 </section>
 
 <div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="clientecrud" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>



</body>
</html>