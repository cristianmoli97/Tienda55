package com.tiendaMinTicDao;

import java.sql.*;
import java.util.ArrayList;

import com.tiendaMinTicDto.UsuariosVO;

public class UsuariosDao {
	public ArrayList<UsuariosVO> listarUsuarios(){
		ArrayList<UsuariosVO> listaUsuarios= new ArrayList<>() ;
		Conexion conex=new Conexion();
		try {
			String query="Select cedula_usuario,email_usuario,nombre_usuario,password_usuario,usuario from usuarios";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			while(res.next()) {
				UsuariosVO usuario=new UsuariosVO();
				usuario.setCedula(res.getInt("cedula_usuario"));
				usuario.setUsuario (res.getString("usuario"));
				usuario.setPasswordUsuario(res.getString("password_usuario"));
				usuario.setNombreUsuario(res.getString("nombre_usuario"));
				usuario.setCorreoUsuario(res.getString("email_usuario"));
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
		Conexion conex=new Conexion();
		 if (conex != null) {
	                String query = "";
	                boolean estatus=false;
		try {
			query="Select cedula_usuario,email_usuario,nombre_usuario,password_usuario,usuario from usuarios where cedula_usuario=?";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			consulta.setInt(1,id);
			ResultSet res=consulta.executeQuery();
			
			
			if (res.next()) {
				UsuariosVO usuario=new UsuariosVO();
				usuario.setCedula(res.getInt("cedula_usuario"));
				usuario.setUsuario (res.getString("usuario"));
				usuario.setPasswordUsuario(res.getString("password_usuario"));
				usuario.setNombreUsuario(res.getString("nombre_usuario"));
				usuario.setCorreoUsuario(res.getString("email_usuario"));
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
		Conexion conex=new Conexion();
		if (conex != null && user != null) { 
		try {
			String query = "insert into usuarios (cedula_usuario,email_usuario,nombre_usuario,password,usuario)"
			 + "values (?,?,?,?,?)";

			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setInt(1, user.getCedula());
			consulta.setString(2,user.getCorreoUsuario());
			consulta.setString(3, user.getNombreUsuario());
			consulta.setString(4, user.getPasswordUsuario());
			consulta.setString(5, user.getUsuario());
		

			if (this.consultarUsuario(user.getCedula()) == null) {  // si el usuario no esxiste registra usuario
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
		Conexion conex=new Conexion();
		try{
			String query ="UPDATE usuarios SET usuario = ?, password = ?, nombre_usuario = ?, email_usuario = ? WHERE cedula_usuario = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			
			
			consulta.setString(1, user.getUsuario());
			consulta.setString(2, user.getPasswordUsuario());
			consulta.setString(3, user.getNombreUsuario());
			consulta.setString(4,user.getCorreoUsuario());
			consulta.setInt(5, user.getCedula());
			

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

	
	public boolean eliminarUsuario(int id) {
		Conexion conex=new Conexion();
		 boolean estatus=false;
		 
		try {
			String query = "DELETE FROM usuarios WHERE cedula_usuario ='"+id+"'";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
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
