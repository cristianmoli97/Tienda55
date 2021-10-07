package com.tiendaMinTic;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaMinTic.CSV.Servicios.ServicioAutenticar;
import com.tiendaMinTicDao.ProductosDAO;
import com.tiendaMinTicDto.ProductosVO;
import com.tiendaMinTicDto.UsuariosVO; 

@Controller
public class ProveedoresController {
	
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
    

     @GetMapping(value = {"/clientescrud"})  
	      public String updateContact2(Model model) {
	      	ClienteVO cliente = new ClienteVO();
	          model.addAttribute("cliente",cliente);
	          model.addAttribute("popupActive", "hidden");
	          model.addAttribute("popupMsj", "");
	          return "clienteForm";
    }


    @PostMapping("/registerCliente")
    public String registrarCliente (@Valid ClienteVO cliente, @RequestParam("evento_boton_crud_cliente") String botonCrudCliente , Model model){
        ClienteDao clienteD = new ClienteDao();

        String redireccion ="clienteForm";

         switch(botonCrudProveedor){
             case ""Consultar":
              if(clienteD.buscarCliente(cliente.getCedulaCliente()) != null) {
					  
					  model.addAttribute("popupMsj", "cliente en base de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "cliente inexistente");
				  }
				  cliente.setDefault(); // pone a cero los datos del cliente
				  model.addAttribute("cliente",cliente);
			
				  model.addAttribute("popupActive", "visible");
	
				  

				  break;
			  case "Crear":
				  if(clienteD.registrarCliente(cliente)) {
					  
					  model.addAttribute("popupMsj", "cliente guardado enbase de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "cliente ya registrado o no creado intente nuevamente");
				  }
				  cliente.setDefault(); // pone a cero los datos del cliente
				  model.addAttribute("cliente",cliente);
			
				  model.addAttribute("popupActive", "visible");
				  
				  
				  break;
				  
			  case "Actualizar":
				  
			  	  if(clienteD.actualizarCliente(cliente)) {
			  		  model.addAttribute("popupMsj", "cliente actualizado en base de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "cliente no actualizado o inexistente intente nuevamente");
				  }
				  cliente.setDefault(); // pone a cero los datos del proveedor
				  model.addAttribute("cliente",cliente);
			
				  model.addAttribute("popupActive", "visible");
				  
				  break;
				  
			  case "Borrar":
				  
			  	  if(clienteD.borrarCliente(cliente.getCedulaCliente())) {
			  		  model.addAttribute("popupMsj", "cliente eliminado de en base de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "cliente no eliminado o inexistente");
				  }
				  proveedor.setDefault(); // pone a cero los datos del proveedor
				  model.addAttribute("proveedor",proveedor);
			
				  model.addAttribute("popupActive", "visible");
			  				  
			default:
				break;
				
		  }
		  
		  return redireccion;
					  



         }





    }



}