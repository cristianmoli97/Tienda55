package com.tiendaMinTic;

import java.util.ArrayList;
import com.tiendaMinTicDao.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.tiendaMinTicDto.*;
@RestController
public class ClienteControlador {

	
	@RequestMapping("/listarClientes")
	public ArrayList<ClienteVO> listar(){
		ClienteDao dao = new ClienteDao();
		
		
		
		
		return dao.listarClientes();}
	
	
	
	@RequestMapping("/consultarCliente")
	public  ArrayList<ClienteVO> consultar(int cedula){
		ClienteDao dao  = new  ClienteDao();
		
		return dao.buscarCliente(cedula);
		
	}
	
	@RequestMapping("/agregarCliente")
	public void agregarCliente (ClienteVO persona) {
		ClienteDao  dao =new ClienteDao();
		dao.registrarCliente(persona);
	}
}
