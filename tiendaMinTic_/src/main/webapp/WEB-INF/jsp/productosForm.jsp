<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>productorForm</title>
<link href="/static/css/style_usu.css" rel="stylesheet" type="text/css">    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/productosform.js"> </script>


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
  <form:form action="crudproductoform"  method="post" modelAttribute="producto" id="produForm"> 
    <h4>Seleccione operacion a realizar:</h4>
    <div class=botones>
    	<button class="botons" id="btn_consultar" type="button">Consultar</button>
    	<button class="botons"  id="btn_crear" type="button">Crear</button>
    	<button class="botons"  id="btn_actualizar" type="button">Actualizar</button>
    	<button class="botons"  id="btn_borrar"  type="button">Borrar</button>
    </div>

    <form:input class="controls" type="text" path="codigoProducto" name="codigoProducto" id="codigoProducto" pattern="[0-9]{1,12}" placeholder="codigo Producto" required="required" />
    <form:input class="controls" type="text" path="ivaCompra" name="ivaCompra" id="ivaCompra" pattern="[0-9]{1,2}" placeholder="iva Compra"/>
    <form:input class="controls" type="text" path="nitProveedor" name="nitProveedor" id="nitProveedor" pattern="[0-9]{1,2}" placeholder="nit Proveedor" />
    <form:input class="controls" type="text" path="nombreProducto" name="nombreProducto" id="nombreProducto" pattern="[a-z,A-Z,0-9]{1,15}" placeholder="nombre Producto"/>
    <form:input class="controls" type="text" path="precioCompra" name="precioCompra" id="precioCompra" pattern="[0-9]{1,10}" placeholder="precio Compra"/>
    <form:input class="controls" type="text" path="precioVenta" name="precioVenta" id="precioVenta" pattern="[0-9]{1,10}" placeholder="precio Venta"/>
    <div id="tabla" style="position: absolute; left: 25%; top: 35%; visibility: ${tableActive};">
 
    <table border="1" class="styled-table">
    
            <thead>
                <tr>
                    <th>codigoProducto</th>
                    <th>ivacompra</th>
                    <th>nitproveedor</th>
                    <th>nombreProducto</th>
                    <th>precioCompra</th>
                    <th>precioVenta</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${listaproducto}">                
                <tr>
                    <td>${f.getCodigoProducto()}</td>
                    <td>${f.getIvaCompra()}</td>
                    <td>${f.getNitProveedor()}</td>
                    <td>${f.getNombreProducto()}</td>
                    <td>${f.getPrecioCompra()}</td>
                    <td>${f.getPrecioVenta()}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>

    
    </div>
    <div class=botonaceptar>
    	<input class="botonsaceptar" type="submit" id="btn_aceptar" name="evento_boton_crud_producto" style="visibility:hidden" />
    	
    </div>
  </form:form>
  </section>
  <div class="window-notice" id="window-notice" style="visibility: ${popupActive}">
    <div class="content">
        <div class="content-text">${popupMsj}. 
        
        <div class="content-buttons"> <a href="prodcrud" id="close-button2">Aceptar</a></div>
    	</div>
	</div>
</div>

</body>
</html>