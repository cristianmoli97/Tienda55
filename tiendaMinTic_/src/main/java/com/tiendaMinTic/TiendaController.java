package com.tiendaMinTic;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTic.CSV.Servicios.ServicioAutenticar;
import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDao.ProveedorDao;
import com.tiendaMinTicDto.ProductosVO;
import com.tiendaMinTicDto.UsuariosVO; 

@Controller
public class TiendaController {
	
	@GetMapping(value="/")
    public ModelAndView paginadefault(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	@GetMapping(value="/login")
    public ModelAndView PaginaLogin(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	
	@PostMapping(value="/loginform")
    public ModelAndView AcessoUsuario(@RequestParam("username") String username, @RequestParam("password") String password){
        
    	ServicioAutenticar userAutenticar = new ServicioAutenticar();
		UsuariosVO usuVO = new UsuariosVO();
		usuVO.setUsuario(username);
		usuVO.setPasswordUsuario(password);
		

        ModelAndView mav = new ModelAndView();
        if (!userAutenticar.autenticar(usuVO)) {
            mav.setViewName("redirect:login");
        }else {
        	mav.setViewName("redirect:prodcrud");
        }
        return mav;
    }
	
	
	// Interfaz cargar archivo csv
	@GetMapping(value = {"/producto"})
	  public ModelAndView prodcsv(){

		  ModelAndView mav = new ModelAndView("productos");
	  
	  return mav; }
	
	
	 // CRUD Productos
    @GetMapping(value = {"/prodcrud"})  
    public String updateContact(Model model) {
    	ProductosVO producto = new ProductosVO();
        model.addAttribute("producto",producto);
        model.addAttribute("popupActive", "hidden");
        model.addAttribute("popupMsj", "");
        return "productosForm";
 }
    
      //Al hacer click sobre alguno de los botones
	  @PostMapping("/registrarproductoform")
	  public String registrarusuario(@Valid @ModelAttribute("producto") ProductosVO producto,@ModelAttribute("evento_boton_crud_producto") String botonCrudProducto , Model model) {
 
		  ProductosDAO prodDao=new ProductosDAO();
		  ProveedorDao provDao = new ProveedorDao();
		  
		  String redireccion = "productosForm";
		
		  switch(botonCrudProducto) {
			  case "Consultar":
				 
				  if(prodDao.buscarProducto(producto.getCodigoProducto()) != null) {
					  
					  
					  model.addAttribute("popupMsj", "Producto en base de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "Producto inexistente");
				  }
				  producto.setDefault(); // pone a cero los datos del producto
				  model.addAttribute("producto",producto);
			
				  model.addAttribute("popupActive", "visible");
				  

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

				  if(provDao.buscarProveedor(producto.getNitProveedor()).size() > 0){  // si existe el proveedor procede a actualizar
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
