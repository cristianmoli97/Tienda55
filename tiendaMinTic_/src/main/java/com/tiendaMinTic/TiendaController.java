package com.tiendaMinTic;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDao.UsuarioDAO; //alison agrega estos objetos
import com.tiendaMinTicDto.ProductosVO;
import com.tiendaMinTicDto.UsuarioVO; //alison agrega estos objetos

@Controller
public class TiendaController {
	
	@GetMapping(value="/")
    public ModelAndView defaultPage(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	@GetMapping(value="/login")
    public ModelAndView showLoginPage(){
		ModelAndView mav = new ModelAndView("login0");
		return mav;
    }
	
	
	@PostMapping(value="/loginform")
    public ModelAndView AcessoUsuario(@RequestParam("username") String username, @RequestParam("password") String password){
        
    	UsuarioDAO usudao=new UsuarioDAO();
		UsuarioVO usuVO = new UsuarioVO();
		usuVO.setNombreUsuario(username);
		usuVO.setClave(password);
		
    	boolean isValidUser = usudao.autenticar(usuVO);
        ModelAndView mav = new ModelAndView();
        if (!isValidUser) {
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
	  public String registrarusuario(@Valid ProductosVO producto, @RequestParam("evento_boton_crud_producto") String botonCrudProducto , Model model) {
         
		  ProductosDAO prodDao=new ProductosDAO();
		  
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
				  if(prodDao.registrarProducto(producto)) {
					  
					  model.addAttribute("popupMsj", "Producto guardado enbase de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "Producto ya registrado o no creado intente nuevamente");
				  }
				  producto.setDefault(); // pone a cero los datos del producto
				  model.addAttribute("producto",producto);
			
				  model.addAttribute("popupActive", "visible");
				  
				  
				  break;
				  
			  case "Actualizar":
				  
			  	  if(prodDao.actualizarProducto(producto)) {
			  		  model.addAttribute("popupMsj", "Producto actualizado en base de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "Producto no actualizado o inexistente intente nuevamente");
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
