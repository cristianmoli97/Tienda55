package com.Tienda2Dao;
import java.sql.*;
import java.util.ArrayList;

import com.TiendawebDto.UsuariosVO;

public class UsuariosDao {
	public ArrayList<UsuariosVO> listarPersona(){
		ArrayList<UsuariosVO> listaUsuario= new ArrayList<>() ;
		Conexion conex=new Conexion ();
		try {
			String query="Select Cedula,Usuario,Contraseña,Nombre,Correo from usuarios";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			while(res.next()) {
				UsuariosVO usuario=new UsuariosVO();
				usuario.setCedula(res.getInt("Cedula"));
				usuario.setUsuario (res.getString("Usuario"));
				usuario.setPasswordUsuario(res.getString("Contraseña"));
				usuario.setNombreUsuario(res.getString("Nombre"));
				usuario.setCorreoUsuario(res.getString("Correo"));
				listaUsuario.add(usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		}catch (Exception e) {
			System.out.println("Erroro listar..." + e);
		}
		return listaUsuario;
			
	}
	public ArrayList<UsuariosVO> consultarPersona(int id){
		ArrayList<UsuariosVO> listaUsuario= new ArrayList<> ();
		Conexion conex=new Conexion();
		try {
			String query="Select Cedula,Usuario,Contraseña,Nombre,Correo from usuarios where Cedula=?";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			consulta.setInt(1,id);
			ResultSet res=consulta.executeQuery();
			if (res.next()) {
				UsuariosVO user=new UsuariosVO();
				user.setCedula(res.getInt("Cedula"));
				user.setUsuario (res.getString("Usuario"));
				user.setPasswordUsuario(res.getString("Contraseña"));
				user.setNombreUsuario(res.getString("Nombre"));
				user.setCorreoUsuario(res.getString("Correo"));
				listaUsuario.add(user);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();
			
		}catch(Exception e) {
			System.out.println("Error consultarPersona..."+e);
			
		}
		return listaUsuario;
	}
	public void registrarPersona(UsuariosVO persona){
		Conexion conex=new Conexion();
		try {
			Statement est=conex.getConnection().createStatement();
			String query="insert into usuarios (Cedula,Usuario,Contraseña,Nombre,Correo)" + "values ("+persona.getCedula()+",'"+persona.getPasswordUsuario()+"','"+persona.getUsuario()+"','"+persona.getCorreoUsuario()+"','"+persona.getNombreUsuario()+"');";
			est.executeUpdate(query);
			System.out.println("Registro correcto");
			est.close();
			conex.desconectar();
		
		}catch (Exception e) {
			System.out.println("Error regisstrado"+e);
			
			//TODO:handle exception
		}		
	}
}
