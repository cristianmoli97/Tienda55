package com.tiendaMinTic;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tiendaMinTicDao.ClienteDao;
import com.tiendaMinTicDao.DetallesDAO;
import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDao.VentasDAO;
import com.tiendaMinTicDto.CarritoVenta;
import com.tiendaMinTicDto.ClienteVO;
import com.tiendaMinTicDto.DetalleVO;
import com.tiendaMinTicDto.ProductosVO;
import com.tiendaMinTicDto.VentasVO;



@Controller
public class VentasController {

	@GetMapping(value="/ventas")		
    public ModelAndView paginadefault(){
		ModelAndView mav = new ModelAndView("ventas");
		return mav;
    }
	
	ClienteVO objCliente = new ClienteVO();
	ArrayList<CarritoVenta> listAllP = new ArrayList<>() ;
	ProductosVO productoActual = new ProductosVO();
	Double totalN = 0.0;
	double totalIva = 0.0;
	double totalPro = 0.0;
	long documentoCliente;
	ArrayList<ProductosVO> listaProducto1 = new ArrayList<>();
	
	@PostMapping(value="/ventasSearch")
    public String AccederReportes(@ModelAttribute("evento_boton_ventas") String butonVentas, @RequestParam(name = "docCliente") String txtDocumentoCliente, @RequestParam(name = "idProducto") String txtIdProducto, @RequestParam(name = "idCantidad") String txtIdCnatidad, @RequestParam(name = "idTotalP") String txtValorTUnidadP, Model model){
		String redireccion = "ventas";
			
		if(txtDocumentoCliente != "") documentoCliente = Long.parseLong(txtDocumentoCliente);
		else documentoCliente = 0;	
		
		VentasDAO ventasdao = new VentasDAO();
		VentasVO ventasveo = new VentasVO();
		DetalleVO detallesVOO = new DetalleVO();
		DetallesDAO detallesDAOO = new DetallesDAO();
		ProductosDAO productosDAOO = new ProductosDAO();
		ProductosVO productosVOO = new ProductosVO();
		
	
		switch(butonVentas) {
		case "consultar cliente":
				String txtName = "Cliente inexistente";
				ArrayList<ClienteVO> listaCli = new ArrayList<>() ;
				ClienteDao objClienteDao = new ClienteDao();
				txtName = "digite la cedula del cliente";
				listaCli = objClienteDao.buscarCliente(documentoCliente);
				if(listaCli.size() != 0) {
					objCliente.setCedulaCliente(listaCli.get(0).getCedulaCliente());
					objCliente.setCorreoElectronico(listaCli.get(0).getCorreoElectronico());
					objCliente.setDireccion(listaCli.get(0).getDireccion());
					objCliente.setNombreCompleto(listaCli.get(0).getNombreCompleto());
					objCliente.setTelefono(listaCli.get(0).getTelefono());
					txtName =  listaCli.get(0).getNombreCompleto();					
				}
				model.addAttribute("txtName", txtName);
				model.addAttribute("txtDoc", documentoCliente);
				model.addAttribute("listaCarrito", null);
				model.addAttribute("totalN", 0);
				model.addAttribute("totalIva", 0);
				model.addAttribute("totalPro", 0);
				if (listAllP.size()>0) {
					listAllP.clear();
				}
				totalN = 0.0;
				totalIva = 0;
				totalPro = 0;

			break;
			
		case "Consultar":
			long idProductp;
			String txtNameP = "No encontrado";
			String txtCantidadP = "1";
			Double txtValorP = 0.0;
			ProductosDAO objProducto = new ProductosDAO();
			if(objCliente.getNombreCompleto() != "") {
				model.addAttribute("txtName", objCliente.getNombreCompleto());
				model.addAttribute("txtDoc", documentoCliente);
			}
			if(txtIdProducto != "") idProductp = Long.parseLong(txtIdProducto);
			else idProductp = 0;
			listaProducto1 = objProducto.buscarProducto(idProductp);
			if(listaProducto1 != null) {
				txtNameP = listaProducto1.get(0).getNombreProducto();
				txtValorP = listaProducto1.get(0).getPrecioVenta();
				productoActual.setCodigoProducto(listaProducto1.get(0).getCodigoProducto());
				productoActual.setNombreProducto(listaProducto1.get(0).getNombreProducto());
			}
			else {
				txtCantidadP = "0";
				
				productoActual = null;
			}
			
			model.addAttribute("txtNameP", txtNameP);
			model.addAttribute("txtCantidadP", txtCantidadP);
			model.addAttribute("txtValorP", txtValorP);
			if(listAllP != null) {				
				model.addAttribute("listaCarrito",listAllP);
				model.addAttribute("totalN", totalN);
				model.addAttribute("totalIva", totalIva);
				model.addAttribute("totalPro", totalPro);
			}
			
			break;
			
		case "Agregar":
			if(objCliente.getNombreCompleto() != "") {
				model.addAttribute("txtName", objCliente.getNombreCompleto());
				model.addAttribute("txtDoc", documentoCliente);
			}
			CarritoVenta addPro = new CarritoVenta();
			addPro.setCodigo_producto(productoActual.getCodigoProducto());
			addPro.setNombre_producto(productoActual.getNombreProducto());
			addPro.setValor_total(Double.parseDouble(txtValorTUnidadP));
			addPro.setCantidad_producto(Integer.parseInt(txtIdCnatidad));
			listAllP.add(addPro);
			if(listAllP != null) {				
				model.addAttribute("listaCarrito",listAllP);
				totalN = totalN + Double.parseDouble(txtValorTUnidadP);
				totalIva = totalN * 0.19;
				totalPro = totalN + totalIva;
				model.addAttribute("totalN", totalN);
				model.addAttribute("totalIva", totalIva);
				model.addAttribute("totalPro", totalPro);
			}
			break;
			
		case "addVenta":
			
			ventasveo.setCodigoVentas(0);
			ventasveo.setCedulaCliente(documentoCliente);
			ventasveo.setCedulaUsuario(2);
			ventasveo.setValorVenta(totalN);
			ventasveo.setIvaVenta(totalIva);
			ventasveo.setTotalVenta(totalPro);
			
			ventasdao.registrarVenta(ventasveo);
			
			for (CarritoVenta carrito: listAllP){
				
				detallesVOO.setCodigo_detalle_venta(0);
				detallesVOO.setCantidad_producto(carrito.getCantidad_producto());
				detallesVOO.setCodigo_producto(carrito.getCodigo_producto());
				detallesVOO.setCodigo_venta(ventasveo.getCodigoVentas());
				detallesVOO.setValor_total(carrito.getValor_total());
				ArrayList<ProductosVO> listaProductoX =new ArrayList<>();
				listaProductoX = productosDAOO.buscarProducto(carrito.getCodigo_producto());
				Double productosX = 0.0;

				if (listaProductoX != null) {
					
					for(ProductosVO productosVOX: listaProductoX) {
						productosX = productosVOX.getIvaCompra();	
					}
				}
									
				Double valorIvaProducto = carrito.getValor_total() * productosX;
				detallesVOO.setValoriva(valorIvaProducto);
				Double valorVentaProducto = carrito.getValor_total() + valorIvaProducto;
				detallesVOO.setValor_venta(valorVentaProducto);
				// Double valorTotalProducto = carrito.getValor_total() * (carrito.getCantidad_producto());
		
				detallesDAOO.registrarDetalleVenta(detallesVOO);
				
				
			}
			  			
			
		break;

			default:
				
				  break;
		}
		return redireccion;
	}
	
}
