package com.tiendaMinTic;

import java.util.ArrayList;

import javax.validation.Valid;

import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDao.ProveedoresDAO;
import com.tiendaMinTicDto.ProductosVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




/**
 * 
 * @author ledyn roman moreno castellanso
 *
 */
@Controller
public class ProductosControlador {

	    	
		 // CRUD Productos
	    @GetMapping(value = {"/prodcrud"})  
	    public String modProductos(Model model) {
	    	String userloginInUse = TiendaMinTicApplication.usernameLoginx; //accede al ususario ingresado en login
	    	if(userloginInUse.equals("nada")) {

				return "redirect:login";
			}else {

				ProductosVO producto = new ProductosVO();
		        model.addAttribute("producto",producto);
		        model.addAttribute("tableActive", "hidden");
		        model.addAttribute("popupActive", "hidden");
		        model.addAttribute("popupMsj", "");
		        return "productosForm";
			}
	    	
	    	
	    	
	 }
	    
	      //Al hacer click sobre alguno de los botones
		  @PostMapping("/crudproductoform")
		  public String registrarproducto(@Valid @ModelAttribute("producto") ProductosVO producto,@ModelAttribute("evento_boton_crud_producto") String botonCrudProducto , Model model) {
	 
			  ProductosDAO prodDao=new ProductosDAO();
			  ProveedoresDAO provDao = new ProveedoresDAO();
			  
			  String redireccion = "productosForm";
	
			  model.addAttribute("tableActive", "hidden");
			  switch(botonCrudProducto) {
				  case "Consultar":
					  ArrayList<ProductosVO> listaProd =new ArrayList<>();
					  listaProd = prodDao.buscarProducto(producto.getCodigoProducto());
					  
					  if(listaProd != null) {
						  model.addAttribute("popupActive", "hidden");
						  model.addAttribute("tableActive", "visible");
						  model.addAttribute("listaproducto",listaProd);
						  
					  }else {
						  model.addAttribute("popupActive", "visible");
						  model.addAttribute("popupMsj", "Producto inexistente");
						  model.addAttribute("tableActive", "hidden");
					  }
					  producto.setDefault(); // pone a cero los datos del producto
					 
				    
					  
					  
					  break;
				  case "Crear":
					
					  if(provDao.buscarProveedor(producto.getNitProveedor()).size() > 0){  // si existe el proveedor procede a regitrar
						  if(prodDao.registrarProducto(producto)) {
						  
							  model.addAttribute("popupMsj", "Producto guardado enbase de datos");
						  
						  }else {
							  model.addAttribute("popupMsj", "Producto ya registrado, o no creado intente nuevamente");
						  }
					  }else {
						  
						  model.addAttribute("popupMsj", "Producto no registrado, Nit proveedor incorrecto");
					  }
					  producto.setDefault(); // pone a cero los datos del producto
					  model.addAttribute("producto",producto);
				
					  model.addAttribute("popupActive", "visible");
					  				  
					  break;
					  
				  case "Actualizar":
					
					  if(provDao.buscarProveedor(producto.getNitProveedor()) != null){  // si existe el proveedor procede a actualizar
						  if(prodDao.actualizarProducto(producto)) {
							  model.addAttribute("popupMsj", "Producto actualizado en base de datos");
						  
						  }else {
							  model.addAttribute("popupMsj", "Producto no actualizado o inexistente intente nuevamente");
						  }
						  
					  }else {
						  model.addAttribute("popupMsj", "Producto no Actualizado, Nit proveedor incorrecto");
					  }
					  
					  producto.setDefault(); // pone a cero los datos del producto
					  model.addAttribute("producto",producto);
			
					  model.addAttribute("popupActive", "visible");
					  break;
					  
				  case "Borrar":
					
				  	  if(prodDao.eliminarProducto(producto.getCodigoProducto())) {
				  		  model.addAttribute("popupMsj", "Producto eliminado de enbase de datos");
						  
					  }else {
						  model.addAttribute("popupMsj", "Producto no eliminado o inexistente");
					  }
					  producto.setDefault(); // pone a cero los datos del producto
					  model.addAttribute("producto",producto);
				
					  model.addAttribute("popupActive", "visible");
				  				  
				default:
					break;
					
			  }

			  return redireccion;					  

		  }
}
