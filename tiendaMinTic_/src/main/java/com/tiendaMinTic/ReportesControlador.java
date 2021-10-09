package com.tiendaMinTic;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import com.tiendaMinTicDao.ClienteDao;
import com.tiendaMinTicDao.UsuariosDao;
import com.tiendaMinTicDao.VentasDAO;
import com.tiendaMinTicDto.ClienteVO;

import com.tiendaMinTicDto.UsuariosVO;
import com.tiendaMinTicDto.VentasVO;
import com.tiendaMinTicDto.reportesVO;

@Controller
public class ReportesControlador {

	
	@GetMapping(value="/reportesall")
    public String paginareportes(Model model){
		model.addAttribute("tableActive", "hidden");
        model.addAttribute("popupActive", "hidden");
        model.addAttribute("popupMsj", "");
		return "reportes";
    }
	
	@PostMapping(value="/reportesapp")
    public String AccederReportes( @ModelAttribute("evento_boton_reportes") String botonreportes , Model model){
        
		String redireccion = "reportes";
		ArrayList<reportesVO> listrepo = new ArrayList<>() ;
		
		model.addAttribute("tableActive", "hidden");
		  switch(botonreportes) {
			  case "listado de usuarios":
				  ArrayList<UsuariosVO> listaUsu = new ArrayList<>() ;
				  
				  UsuariosDao usdao = new UsuariosDao();

			      
				  listaUsu = usdao.listarUsuarios();
				  
				  if(listaUsu != null) {
					  model.addAttribute("labelcampo1","Cedula");
					  model.addAttribute("labelcampo2","Nombre");
					  model.addAttribute("labelcampo3","CorreoElectronico");
					  model.addAttribute("labelcampo4","Usuario");
					  model.addAttribute("labelcampo5","Password");
					  
					  
					  
					  for(UsuariosVO usu1: listaUsu) {
						  reportesVO repor = new reportesVO();
						  repor.setCampo1(String.valueOf(usu1.getCedula()));
						  repor.setCampo2(usu1.getNombreUsuario());
						  repor.setCampo3(usu1.getCorreoUsuario());
						  repor.setCampo4(usu1.getUsuario());
						  repor.setCampo5(usu1.getPasswordUsuario());
						  repor.setCampo6("");
						  listrepo.add(repor);
					  }
					  model.addAttribute("listareporte",listrepo);
					  model.addAttribute("popupActive", "hidden");
					  model.addAttribute("tableActive", "visible");
	
					  
				  }else {
					  model.addAttribute("popupActive", "visible");
					  model.addAttribute("popupMsj", "No se encontraron usuarios");
					  model.addAttribute("tableActive", "hidden");
				  }

				  break;
			  case "listado de clientes":
				  ArrayList<ClienteVO> listaCli = new ArrayList<>() ;
				  
				  ClienteDao clidao = new ClienteDao();
				  
			      
				  listaCli = clidao.listarClientes();
				  
				  if(listaCli != null) {
					  model.addAttribute("labelcampo1","Cedula");
					  model.addAttribute("labelcampo2","Nombre");
					  model.addAttribute("labelcampo3","CorreoElectronico");
					  model.addAttribute("labelcampo4","Direccion");
					  model.addAttribute("labelcampo5","Telefono");
					  
					  
					  
					  for(ClienteVO cli1: listaCli) {
						  reportesVO repor = new reportesVO();
						  repor.setCampo1(String.valueOf(cli1.getCedulaCliente()));
						  repor.setCampo2(cli1.getNombreCompleto());
						  repor.setCampo3(cli1.getCorreoElectronico());
						  repor.setCampo4(cli1.getDireccion());
						  repor.setCampo5(cli1.getTelefono());
						  repor.setCampo6("");
						  listrepo.add(repor);
					  }
					  model.addAttribute("listareporte",listrepo);
					  model.addAttribute("popupActive", "hidden");
					  model.addAttribute("tableActive", "visible");
	
					  
				  }else {
					  model.addAttribute("popupActive", "visible");
					  model.addAttribute("popupMsj", "No se encontraron usuarios");
					  model.addAttribute("tableActive", "hidden");
				  }

				  break;
			  case "ventas por cliente":
				    
				  ArrayList<VentasVO> listaventas = new ArrayList<>() ;
				  ArrayList<ClienteVO> listaclientes = new ArrayList<>() ;
				  VentasDAO ventasdao = new VentasDAO ();
	
			      
				  listaventas = ventasdao.listarVentas();
				  
				  if(listaventas != null) {
					  model.addAttribute("labelcampo1","Cedula Cliente");
					  model.addAttribute("labelcampo2","Nombre Cliente");
					  model.addAttribute("labelcampo3","Valor Total ventas");
					  model.addAttribute("labelcampo4","");
					  model.addAttribute("labelcampo5","");
					  
					  ClienteDao clidao2 = new ClienteDao();
					  
					  
					  
					  for( VentasVO ventas1: listaventas) {
						  reportesVO repor = new reportesVO();
						  
						  listaclientes = clidao2.buscarCliente(ventas1.getCedulaCliente());
						  for( ClienteVO clie2: listaclientes) {
							  if(clie2.getCedulaCliente() == ventas1.getCedulaCliente()) {
								  repor.setCampo2(clie2.getNombreCompleto());  
								  break;
							  }
						  
						  }
								  
						  repor.setCampo1(String.valueOf(ventas1.getCedulaCliente())); 
						  repor.setCampo3(String.valueOf(ventas1.getTotalVenta()));
						  repor.setCampo4("");
						  repor.setCampo5("");
						  repor.setCampo6("");
						  listrepo.add(repor);
					  }
					  model.addAttribute("listareporte",listrepo);
					  model.addAttribute("popupActive", "hidden");
					  model.addAttribute("tableActive", "visible");
	
					  
				  }else {
					  model.addAttribute("popupActive", "visible");
					  model.addAttribute("popupMsj", "No se encontraron ventas ");
					  model.addAttribute("tableActive", "hidden");
				  }
				  
				  
				  break;
				  
				  default:
					  break;
		  }
		
        return redireccion;
    }
	
	
}
