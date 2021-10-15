<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/static/css/ventas.css">
    <title>Document</title>
</head>
<body>
    <div class="boxContainer">
        <nav class="menu">
            <ul>
                <li><a href="usuarioscrud">USUARIOS</a></li>
                <li><a href="clientecrud">CLIENTES</a></li>
                <li><a href="/proveedorescrud">PROVEEDORES</a></li>
                <li><a href="/producto">PRODUCTOS</a></li>
                <li><a href=/ventas">VENTAS</a></li>
                <li><a href="/reportesall">REPORTES</a></li>
                <li><a href="/login">LOGOUT</a></li>
            </ul>
        </nav>
        <section class="formBox">
          <form:form action="ventasSearch"  method="post" modelAttribute="cliente" id="searchCliente">
                <div class="flexCliente">
                    <div>
                        <input type="number" name="docCliente" value="${txtDoc}" class="inputPRO" id="docCliente" placeholder="Cedula" onkeyup="validarDoc(this)">
                        <input class="buttonPRO" type="submit" id="btnSearchCliente" value = "consultar cliente" name="evento_boton_ventas" disabled/>
                    </div>
                    <p class="textoBalnco"><c:out value="${txtName}"/></p>
                </div>
                <div class="addProducto">
                    <input type="text" class="inputPRO" name="idProducto" placeholder="Cod Producto" onkeyup="validarProducto(this)">
                    <input class="buttonPRO mr15px" type="submit" id="btnSearchProducto" value = "Consultar" name="evento_boton_ventas" disabled/>
                    <input type="text" class="inputPRO" id="idTxtNameP" value="${txtNameP}" disabled placeholder="Nombre producto">
                    <input type="number" class="inputPRO" name="idCantidad" value="${txtCantidadP}" placeholder="Cant" onkeyup="valorCantidadProdcuto(this)" onchange="valorCantidadProdcuto(this)"/>
                    <input type="text" class="inputPRO" id="txtValorU" value="${txtValorP}" disabled placeholder="Vlr unidad"/>
                    <input type="text" class="inputPRO" name="idTotalP" id="txtValorPT" value="${txtValorP}" placeholder="Vlr Total"/>
                    <input class="buttonPRO" type="submit" id="btnAddProducto" value = "Agregar" name="evento_boton_ventas" disabled/>
                </div>
                <div>
                    
                    <table border="1" class="styled-table">
                    	<caption>Carrito</caption>
            			<thead>
                			<tr>
                    			<th id="repocol1c">Nombre de producto</th>
                    			<th id="repocol2c">Cantidad</th>
                    			<th id="repocol3c">Valor</th>
                			</tr>
            			</thead>
            			<tbody>
            			<c:forEach var="f" items="${listaCarrito}">                
                			<tr>
                    			<td id="repocol1">${f.getNombre_producto()}</td>
                    			<td id="repocol2">${f.getCantidad_producto()}</td>
                    			<td id="repocol3">${f.getValor_total()}</td>
                			</tr>
            			</c:forEach> 
        				</tbody>
    				</table>
                    

                    <p class="textoBalnco">Total Venta: $<c:out value="${totalN}"/></p>
                    <p class="textoBalnco">Total IVA : $<c:out value="${totalIva}"/></p>
                    <p class="textoBalnco">Total con IVA : $<c:out value="${totalPro}"/></p>
                </div>
               

                <button class="buttonPRO mrT15px" name="evento_boton_ventas" value="addVenta">Confirmar</button>
            </form:form> 
        </section>    
    </div>
    
    <script src="/static/js/ventas.js"> </script>
</body>
</html>