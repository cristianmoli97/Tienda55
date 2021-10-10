package com.tiendaMinTic;


import com.tiendaMinTicDao.ProveedoresDAO;
import com.tiendaMinTicDto.ProveedoresVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ProveedorControlador {

    	// CRUD Proveedores
	@GetMapping(value = {"/proveedorescrud"})  
	public String updateContact2(Model model) {
		ProveedoresVO proveedor = new ProveedoresVO();
		model.addAttribute("proveedor",proveedor);
		model.addAttribute("tableActive", "hidden");
		model.addAttribute("popupActive", "hidden");
		model.addAttribute("popupMsj", "");
		return "proveedoresForm";
 }

//Al hacer click sobre alguno de los botones
@PostMapping("/registrarproveedorform")
public String registrarProveedor(@ModelAttribute("proveedor") ProveedoresVO proveedor, @RequestParam("evento_boton_crud_proveedor") String botonCrudProveedor , Model model) {
   
	ProveedoresDAO provDao=new ProveedoresDAO();
	
	String redireccion = "proveedoresForm";
	model.addAttribute("tableActive", "hidden");
	switch(botonCrudProveedor) {
		case "Consultar":
			ArrayList<ProveedoresVO> listaProveedores = new ArrayList<>();
			listaProveedores = provDao.buscarProveedor(proveedor.getNitProveedor());
			
			if (listaProveedores != null) {
				model.addAttribute("popupActive", "hidden");
				model.addAttribute("tableActive", "visible");
				model.addAttribute("listaproveedores",listaProveedores);
			}
			
			else {
				model.addAttribute("popupActive", "visible");
				model.addAttribute("popupMsj", "Proveedor inexistente");
				model.addAttribute("tableActive", "hidden");
			}
			/*
			if(provDao.buscarProveedor(proveedor.getNitProveedor()) != null) {
				
				model.addAttribute("popupMsj", "Proveedor en base de datos");
				
			}else {
				model.addAttribute("popupMsj", "Proveedor inexistente");
			}
			*/
			proveedor.setDefault(); // pone a cero los datos del proveedor
			/*model.addAttribute("proveedor",proveedor);
	  
			model.addAttribute("popupActive", "visible");*/

			

			break;
		case "Crear":
			if(provDao.registarProveedor(proveedor)) {
				
				model.addAttribute("popupMsj", "Proveedor guardado enbase de datos");
				
			}else {
				model.addAttribute("popupMsj", "Proveedor ya registrado o no creado intente nuevamente");
			}
			proveedor.setDefault(); // pone a cero los datos del proveedor
			model.addAttribute("proveedor",proveedor);
	  
			model.addAttribute("popupActive", "visible");
			
			
			break;
			
		case "Actualizar":
			
			  if(provDao.actualizarProveedor(proveedor)) {
				  model.addAttribute("popupMsj", "Proveedor actualizado en base de datos");
				
			}else {
				model.addAttribute("popupMsj", "Proveedor no actualizado o inexistente intente nuevamente");
			}
			proveedor.setDefault(); // pone a cero los datos del proveedor
			model.addAttribute("proveedor",proveedor);
	  
			model.addAttribute("popupActive", "visible");
			
			break;
			
		case "Borrar":
			
			  if(provDao.eliminarProveedor(proveedor.getNitProveedor())) {
				  model.addAttribute("popupMsj", "Proveedor eliminado de enbase de datos");
				
			}else {
				model.addAttribute("popupMsj", "Proveedor no eliminado o inexistente");
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
