package com.tiendaMinTicDao;

import java.sql.*;
import java.util.ArrayList;

import com.tiendaMinTicDto.UsuariosVO;

public class UsuariosDao {
	public ArrayList<UsuariosVO> listarUsuarios(){
		ArrayList<UsuariosVO> listaUsuarios= new ArrayList<>() ;
		ConexionDB conex=new ConexionDB();
		try {
			String query="Select Cedula,Usuario,Contraseña,Nombre,Correo from usuarios";
			PreparedStatement consulta=conex.getConexion().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			while(res.next()) {
				UsuariosVO usuario=new UsuariosVO();
				usuario.setCedula(res.getInt("Cedula"));
				usuario.setUsuario (res.getString("Usuario"));
				usuario.setPasswordUsuario(res.getString("Contraseña"));
				usuario.setNombreUsuario(res.getString("Nombre"));
				usuario.setCorreoUsuario(res.getString("Correo"));
				listaUsuarios.add(usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		}catch (Exception e) {
			System.out.println("Erroro listar..." + e);
		}
		return listaUsuarios;
			
	}
	public ArrayList<UsuariosVO> consultarUsuario(int id){
		ArrayList<UsuariosVO> listaUsuarios= new ArrayList<> ();
		ConexionDB conex=new ConexionDB();
		 if (conex != null) {
	                String query = "";
	                boolean estatus=false;
		try {
			query="Select Cedula,Usuario,Contraseña,Nombre,Correo from usuarios where Cedula=?";
			PreparedStatement consulta=conex.getConexion().prepareStatement(query);
			consulta.setInt(1,id);
			ResultSet res=consulta.executeQuery();
			
			
			if (res.next()) {
				UsuariosVO usuario=new UsuariosVO();
				usuario.setCedula(res.getInt("Cedula"));
				usuario.setUsuario (res.getString("Usuario"));
				usuario.setPasswordUsuario(res.getString("Contraseña"));
				usuario.setNombreUsuario(res.getString("Nombre"));
				usuario.setCorreoUsuario(res.getString("Correo"));
				listaUsuarios.add(usuario);
			}
			
			res.close();
			consulta.close();
			
			  if(listaUsuarios.size()>0){
				estatus=true;

			 }
			
		}catch(Exception e) {
			System.out.println("Error consultarPersona..."+e);
		}finally{
	           if (!estatus) {
	                	 listaUsuarios =  null;
		   }
		}
	}
	
		conex.desconectar();
		return listaUsuarios;
	}
	public boolean registrarPersona(UsuariosVO user){
		boolean estatus = false;
		ConexionDB conex=new ConexionDB();
		if (conex != null && user != null) { 
		try {
			String cadena = "insert into usuarios (Cedula,Usuario,Contraseña,Nombre,Correo)" + "values ("+user.getCedula()+",'"+user.getPasswordUsuario()+"','"+user.getUsuario()+"','"+user.getCorreoUsuario()+"','"+user.getNombreUsuario()+"');";
		PreparedStatement consulta = conex.getConexion().prepareStatement(query);
			if (this.+consultarUsuario(user.getCedula()) == null) {  // si el usuario no esxiste registra usuario
						consulta.executeUpdate(query);
						estatus =  true;	
				  }  
				 
				
				consulta.close();	
			 } catch (SQLException e) {
				 System.out.println(e.getMessage());
				  estatus = false;
		          }
			 
		 }
		 conex.desconectar();
		 return estatus;
	 }
	public boolean modificarUsuarios(UsuariosVO user) {
		boolean estatus=false;
		ConexionDB conex=new ConexionDB();
		try{
			String query ="UPDATE usuarios SET Usuario = ?, Contraseña = ?, Nombre = ?, Correo = ? WHERE Cedula = ? ";
			PreparedStatement consulta = conex.getConexion().prepareStatement(query);
			
			consulta.setCedula(user.getInt("Cedula"));
			consulta.setUsuario (user.getString("Usuario"));
			consulta.setPasswordUsuario(user.getString("Contraseña"));
			consulta.setNombreUsuario(user.getString("Nombre"));
			consulta.setCorreoUsuario(user.getString("Correo"));
			

		   if( 1 == consulta.executeUpdate()){
				 estatus=true;
			
			}
			consulta.close();
		   
		}catch(SQLException e){
			System.out.println(e);
		}
	   
		conex.desconectar();
		return estatus;
	}

	
	public boolean eliminarUsuario(int id)) {
		ConexionDB conex=new ConexionDB();
		 boolean estatus=false;
		 
		try {
			String query = "DELETE FROM usuarios WHERE Cedula ='"+Id+"'";
			PreparedStatement consulta = conex.getConexion().prepareStatement(query);
			if(consulta.executeUpdate(query) == 1){
				estatus=true;
			}
			consulta.close();
			
			
		 } catch (SQLException e) {
			System.out.println(e.getMessage());
		 }
		 conex.desconectar();
		return estatus;
	}

}
