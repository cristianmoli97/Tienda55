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
					cliente.setCedulaCliente(res.getInt("cedula_cliente"));
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
	
	public ArrayList<ClienteVO> buscarCliente(ClienteVO cliente){
		 ArrayList<ClienteVO> listaCliente = new  ArrayList<ClienteVO>();
	 Conexion conex = new Conexion();
		 
		 try {
				String query="SELECT cedula_cliente,direccion_cliente,email_cliente, nombre_cliente, telefono_cliente FROM clientes where cedula_cliente=? ";
				PreparedStatement consulta= conex.getConnection().prepareStatement(query);
				consulta.setInt(1, cliente.getCedulaCliente());	
				ResultSet res= consulta.executeQuery();
				
				while(res.next()) {
					ClienteVO clientes = new ClienteVO();
					clientes.setCedulaCliente(res.getInt("cedula_cliente"));
					clientes.setDireccion(res.getString("direccion_cliente"));
					clientes.setCorreoElectronico(res.getString("email_cliente"));
					clientes.setNombreCompleto(res.getString("nombre_cliente"));
					clientes.setTelefono(res.getString("telefono_cliente"));
					listaCliente.add(clientes);
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
	
	
	
	
	
	
	public void registrarCliente(ClienteVO cliente) {
		Conexion conex= new Conexion();
		try {
			String query="insert into clientes (cedula_cliente,direccion_cliente,email_cliente, nombre_cliente, telefono_cliente) values =(?,?,?,?,?) ";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);
			consulta.setInt(1, cliente.getCedulaCliente());
			consulta.setString(2, cliente.getDireccion());
			consulta.setString(3,cliente.getCorreoElectronico());
			consulta.setString(4,cliente.getNombreCompleto());
			consulta.setString(5, cliente.getTelefono());
			consulta.executeUpdate();
			consulta.close();
			conex.desconectar();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void borrarCliente (ClienteVO cliente ) {
		Conexion conex = new Conexion();
		try {
			String query =" delete from clientes where cedula_cliente=? ";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);
			consulta.setInt(1, cliente.getCedulaCliente());
			consulta.executeUpdate();
			consulta.close();
			conex.desconectar();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void actualizarCliente(ClienteVO cliente) {
		Conexion conex = new Conexion();
		try {
			String query=" update clientes  set  nombre_cliente=?,direccion_cliente=?, telefono_cliente=?,email_cliente=? where cedula_cliente=?  ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setString(1, cliente.getNombreCompleto());
			consulta.setString(2, cliente.getDireccion());
			consulta.setString(3, cliente.getTelefono());
			consulta.setString(4, cliente.getCorreoElectronico());
			consulta.setInt(5, cliente.getCedulaCliente());
			consulta.executeUpdate();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
