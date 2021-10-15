package com.tiendaMinTicDao;
 import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendaMinTicDto.*;

public class ClienteDao {
	
	
	public ArrayList<ClienteVO> listarClientes(){
		 ArrayList<ClienteVO> listaCliente = new  ArrayList<ClienteVO>();
		 Conexion conex = new Conexion(); 
		 
		 try {
				String query="SELECT cedula_cliente,direccion_cliente,email_cliente, nombre_cliente, telefono_cliente FROM clientes";
				PreparedStatement consulta= conex.getConnection().prepareStatement(query);
				ResultSet res= consulta.executeQuery();
				
				while(res.next()) {
					ClienteVO cliente = new ClienteVO();
					cliente.setCedulaCliente(res.getLong("cedula_cliente"));
					cliente.setDireccion(res.getString("direccion_cliente"));
					cliente.setCorreoElectronico(res.getString("email_cliente"));
					cliente.setNombreCompleto(res.getString("nombre_cliente"));
					cliente.setTelefono(res.getString("telefono_cliente"));
					listaCliente.add(cliente);
					}
				res.close();
				consulta.close();
				conex.desconectar();
			}
			
		
			 catch (Exception e) {
				// TODO: handle exception
				 JOptionPane.showMessageDialog(null, e);
			}
			return listaCliente;
				
		
	}
	
	public ArrayList<ClienteVO> buscarCliente(long cedula){
		 ArrayList<ClienteVO> listaCliente = new  ArrayList<ClienteVO>();
	 	 Conexion conex = new Conexion();
	 	 boolean estatus = false;
		 
		 try {
				String query="SELECT cedula_cliente,direccion_cliente,email_cliente, nombre_cliente, telefono_cliente FROM clientes where cedula_cliente=? ";
				PreparedStatement consulta= conex.getConnection().prepareStatement(query);
				consulta.setLong(1, cedula);	
				ResultSet res= consulta.executeQuery();
				
				while(res.next()) {
					ClienteVO cliente = new ClienteVO();
					cliente.setCedulaCliente(res.getLong("cedula_cliente"));
					cliente.setDireccion(res.getString("direccion_cliente"));
					cliente.setCorreoElectronico(res.getString("email_cliente"));
					cliente.setNombreCompleto(res.getString("nombre_cliente"));
					cliente.setTelefono(res.getString("telefono_cliente"));
					listaCliente.add(cliente);
					}
				res.close();

				if(listaCliente.size()>0){
					estatus=true;
	
				 }

				consulta.close();
				conex.desconectar();
			}
			
		
			 catch (Exception e) {
				// TODO: handle exception
				 JOptionPane.showMessageDialog(null, e);
			}finally{
				if (!estatus) {
					listaCliente =  null;
			    }
		    }
	        conex.desconectar();
			return listaCliente;

	     }
		
	
	
	
	public boolean registrarCliente(ClienteVO cliente) {
		boolean estatus = false;
		Conexion conex= new Conexion();

		try {
			String query="insert into clientes (cedula_cliente,direccion_cliente,"
					+ "email_cliente, nombre_cliente, telefono_cliente) values (?,?,?,?,?) ";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);
			consulta.setLong(1, cliente.getCedulaCliente());
			consulta.setString(2, cliente.getDireccion());
			consulta.setString(3,cliente.getCorreoElectronico());
			consulta.setString(4,cliente.getNombreCompleto());
			consulta.setString(5, cliente.getTelefono());

			if (this.buscarCliente(cliente.getCedulaCliente()) == null) {  // si el usuario no esxiste registra usuario
				consulta.executeUpdate();
				estatus =  true;	
		  } 

								  
			consulta.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			estatus = false;
		}

		conex.desconectar();
		 return estatus;
	}
	
	
	public boolean borrarCliente (ClienteVO cliente ) {
		boolean estatus=false;
		Conexion conex = new Conexion();
		try {
			String query = "DELETE FROM clientes WHERE cedula_cliente ='"+cliente.getCedulaCliente()+"'";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);


			if(consulta.executeUpdate(query) == 1){
				estatus=true;
			}
			consulta.close();
		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		conex.desconectar();
		return estatus;
	}

	
	public boolean actualizarCliente(ClienteVO cliente) {
		boolean estatus=false;
		Conexion conex = new Conexion();
		try {
			String query=" update clientes  set  nombre_cliente=?,direccion_cliente=?, telefono_cliente=?,email_cliente=? where cedula_cliente=?  ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setString(1, cliente.getNombreCompleto());
			consulta.setString(2, cliente.getDireccion());
			consulta.setString(3, cliente.getTelefono());
			consulta.setString(4, cliente.getCorreoElectronico());
			consulta.setLong(5, cliente.getCedulaCliente());
			if( 1 == consulta.executeUpdate()){
				estatus=true;
		   
		   }
		
			consulta.close();

			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		conex.desconectar();
		return estatus;
	}
	
}
