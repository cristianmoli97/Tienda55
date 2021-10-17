package com.tiendaMinTic;


import com.tiendaMinTicDao.ClienteDao;

import com.tiendaMinTicDto.ClienteVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import java.util.ArrayList;



@Controller
public class ClienteControlador {

    	// CRUD cliente
		@GetMapping(value = {"/clientecrud"})  
	public String updateContact2(Model model) {
		String userloginInUse = TiendaMinTicApplication.usernameLoginx; //accede al ususario ingresado en login
    	if(userloginInUse.equals("nada")) {

			return "redirect:login";
		}else {
			ClienteVO cliente = new ClienteVO();
			model.addAttribute("cliente",cliente);
			model.addAttribute("tableActive", "hidden");
			model.addAttribute("popupActive", "hidden");
			model.addAttribute("popupMsj", "");
			return "clienteForm";
		}
	}

	@PostMapping("/registrarcliente")
	public String registrarClientes(@ModelAttribute("cliente") ClienteVO cliente, @ModelAttribute("evento_boton_crud_cliente") String botonCrudCliente , Model model) {

		ClienteDao clienteDao=new ClienteDao();
	
		String redireccion = "clienteForm";
		model.addAttribute("tableActive", "hidden");

		switch(botonCrudCliente) {
			case "Consultar":
				ArrayList<ClienteVO> listacliente = new ArrayList<>();
				listacliente = clienteDao.buscarCliente(cliente.getCedulaCliente());
			
				if (listacliente != null) {
					model.addAttribute("popupMsj", "");
					model.addAttribute("popupActive", "hidden");
					model.addAttribute("tableActive", "visible");
					model.addAttribute("listacliente",listacliente);
				}else {
					model.addAttribute("popupActive", "visible");
					model.addAttribute("popupMsj", "cliente inexistente");
					model.addAttribute("tableActive", "hidden");
				}
			
				cliente.setDefault(); // pone a cero los datos del cliente
					

				break;
			case "Crear":
				if(clienteDao.registrarCliente(cliente)) {
				
					model.addAttribute("popupMsj", "cliente guardado en base de datos");
				
				}else {
					model.addAttribute("popupMsj", "cliente ya registrado o no creado, intente nuevamente");
				}
				cliente.setDefault(); // pone a cero los datos del cliente
				model.addAttribute("cliente",cliente);
	  
				model.addAttribute("popupActive", "visible");
			
			
				break;
			
			case "Actualizar":
				if(clienteDao.buscarCliente(cliente.getCedulaCliente())!=null){
					if(clienteDao.actualizarCliente(cliente)) {
						model.addAttribute("popupMsj", "cliente actualizado en base de datos");
				
					}else {
						model.addAttribute("popupMsj", "cliente no actualizado o inexistente, intente nuevamente");
					}
				}else {
					model.addAttribute("popupMsj", "Cliente no existe");	
				}
			
				cliente.setDefault(); // pone a cero los datos del proveedor
				model.addAttribute("cliente",cliente);
				model.addAttribute("popupActive", "visible");
			
				break;
			
			case "Borrar":
			    
				if(clienteDao.borrarCliente(cliente)) {
					model.addAttribute("popupMsj", "cliente eliminado de la base de datos");
				
				}else {
					model.addAttribute("popupMsj", "cliente no eliminado o inexistente");
				}
				cliente.setDefault(); // pone a cero los datos del cliente
				model.addAttribute("cliente",cliente);
	  
				model.addAttribute("popupActive", "visible");
						  
			default:
				break;
		  
		}
	
		return redireccion;
				
    }

}
