package com.tiendaMinTicDao;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendaMinTicDto.*;


public class ClienteDao {
	
	public ArrayList<ClienteVO> listarPersona(){
		ArrayList<ClienteVO> ListaCliente = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			String query="SELECT idClientes,nombre,apellidos FROM clientes";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);
			ResultSet res= consulta.executeQuery();
			
			while(res.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(res.getInt("idClientes"));
				cliente.setNombreCliente(res.getString("nombre"));
				cliente.setApellidoCliente(res.getString("apellidos"));
				ListaCliente.add(cliente);
				}
			res.close();
			consulta.close();
			conex.desconectar();
		}
		
	
		 catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, e);
		}
		return ListaCliente;
		
	};
	
	

	public ArrayList<ClienteVO> consultarPersona(int id){
		ArrayList<ClienteVO> lista = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			String query="SELECT idClientes,nombre,apellidos FROM clientes  where idClientes=?";
			PreparedStatement consulta= conex.getConnection().prepareStatement(query);
			consulta.setInt(1, id);
			ResultSet res=consulta.executeQuery();
			while(res.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setIdCliente(res.getInt("idClientes"));
				cliente.setNombreCliente(res.getString("nombre"));
				cliente.setApellidoCliente(res.getString("apellidos"));
				lista.add(cliente);
				}
			res.close();
			consulta.close();
			conex.desconectar();
		} catch (Exception e) {
			System.out.println("eror consultar");// TODO: handle exception
		}
		
		
		
		
		
		return lista;};
		
		public void registrarPersona(ClienteVO persona) {
			Conexion conex = new Conexion();
			try {
				
				String query =  "INSERT INTO clientes (idClientes,nombre,apellidos) values(?,?,?) ";
				PreparedStatement consulta= conex.getConnection().prepareStatement(query);
				consulta.setInt(1, persona.getIdCliente());
				consulta.setString(2, persona.getNombreCliente());
				consulta.setString(3, persona.getApellidoCliente());
				consulta.executeUpdate();
				consulta.close();
				conex.desconectar();
			
			} catch (Exception e) {
				System.out.println("error agregar cliente");
				// TODO: handle exception
			}
			
		};
	
	
}
