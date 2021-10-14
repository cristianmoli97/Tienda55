package com.tiendaMinTic;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTicDao.ClienteDao;
import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDto.CarritoVenta;
import com.tiendaMinTicDto.ClienteVO;
import com.tiendaMinTicDto.DetalleVO;
import com.tiendaMinTicDto.ProductosVO;
import com.tiendaMinTicDto.UsuariosVO;
import com.tiendaMinTicDto.reportesVO;

import antlr.collections.List;

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
	
	@PostMapping(value="/ventasSearch")
    public String AccederReportes(@ModelAttribute("evento_boton_ventas") String butonVentas, @RequestParam(name = "docCliente") String txtDocumentoCliente, @RequestParam(name = "idProducto") String txtIdProducto, @RequestParam(name = "idCantidad") String txtIdCnatidad, @RequestParam(name = "idTotalP") String txtValorTUnidadP, Model model){
		String redireccion = "ventas";
		long documentoCliente;
		if(txtDocumentoCliente != "") documentoCliente = Long.parseLong(txtDocumentoCliente);
		else documentoCliente = 0;
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
				if(listAllP != null) {				
					model.addAttribute("listaCarrito",listAllP);
					model.addAttribute("totalN", totalN);
					model.addAttribute("totalIva", totalIva);
					model.addAttribute("totalPro", totalPro);
				}
			break;
			
		case "Consultar":
			long idProductp;
			String txtNameP = "No encontrado";
			String txtCantidadP = "1";
			Double txtValorP = 0.0;
			ArrayList<ProductosVO> listaProducto1 = new ArrayList<>() ;
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
			break;

			default:
				  break;
		}
		return redireccion;
	}
	
}
