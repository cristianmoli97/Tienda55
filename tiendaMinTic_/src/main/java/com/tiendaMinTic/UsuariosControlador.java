package com.tiendaMinTic;

import com.tiendaMinTicDao.UsuariosDao;
import com.tiendaMinTicDto.UsuariosVO;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuariosControlador {
	  
	// CRUD Usuarios
	
    @GetMapping(value = {"/usuarioscrud"})  
    public String updateContact(Model model) {
    	UsuariosVO usuario = new UsuariosVO();
        model.addAttribute("usuario",usuario);
        model.addAttribute("tableActive", "hidden");
        model.addAttribute("popupActive", "hidden");
        model.addAttribute("popupMsj", "");
        return "usuariosForm";
 }
    
      //Al hacer click sobre alguno de los botones
	  @PostMapping("/registrarusuarioform")
	  public String registrarusuario(  @ModelAttribute("usuario") UsuariosVO usuario, @ModelAttribute("evento_boton_crud_usuario") String botonCrudUsuario , Model model) {
         
		  UsuariosDao userDao =new UsuariosDao();
		  
		  String redireccion = "usuariosForm";
		  
		
		  switch(botonCrudUsuario) {
			  case "Consultar":
				  ArrayList<UsuariosVO> listaUsu =new ArrayList<>();
				  listaUsu = userDao.consultarUsuario(usuario);
				  
				  if(userDao.consultarUsuario(usuario) != null) {
					  
					  model.addAttribute("popupMsj", "");
					  model.addAttribute("popupActive", "hidden");
					  model.addAttribute("tableActive", "visible");
					  model.addAttribute("listausuario",listaUsu);
					  
				  }else {
					  model.addAttribute("popupMsj", "Usuario inexistente");
					  model.addAttribute("popupActive", "visible");
					  model.addAttribute("tableActive", "hidden");
				  }
				  usuario.setDefault(); // pone a cero los datos del usuario
			
				  break;
				  
			  case "Crear":
			
				if(userDao.registrarUsuario(usuario)) {
					  
						model.addAttribute("popupMsj", "Usuario guardado en base de datos");
						
					}else {
						model.addAttribute("popupMsj", "Usuario ya registrado o no creado intente nuevamente");
					}
									  
				  usuario.setDefault(); // pone a cero los datos del usuario
				  model.addAttribute("usuario", usuario);
			
				  model.addAttribute("popupActive", "visible");
				  
				  
				  break;
				  
			  case "Actualizar":
				  
			    if(userDao.consultarUsuario(usuario)!=null){
					  if(userDao.modificarUsuarios(usuario)){
			  		  	model.addAttribute("popupMsj", "Usuario actualizado en base de datos");
					  
				  	  }else {
					  model.addAttribute("popupMsj", "Usuario no actualizado, el numero de cedula es incorrecto");
				  	 }
				}else {
					model.addAttribute("popupMsj", "Usuario no existe");	
				}
				  usuario.setDefault(); // pone a cero los datos del usuario
				  model.addAttribute("usuario",usuario);
			
				  model.addAttribute("popupActive", "visible");
				  
				  break;
				  
			  case "Borrar":
				  
			  	  if(userDao.eliminarUsuario(usuario.getCedula())) {
			  		  model.addAttribute("popupMsj", "Usuario eliminado de enbase de datos");
					  
				  }else {
					  model.addAttribute("popupMsj", "Usuario no eliminado o inexistente");
				  }
				  usuario.setDefault(); // pone a cero los datos del usuario
				  model.addAttribute("usuario",usuario);
			
				  model.addAttribute("popupActive", "visible");
			  				  
			default:
				break;
				
		  }
		  
		  return redireccion;
		}
	
}
