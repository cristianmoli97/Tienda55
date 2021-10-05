package com.tiendaMinTic.CSV.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tiendaMinTicDao.Conexion;
import com.tiendaMinTicDto.UsuariosVO;

public class ServicioAutenticar {
	
       public boolean autenticar(UsuariosVO usu) {
               boolean estatus = false;
              
               Conexion conec = new Conexion();
               Connection conectar =conec.getConnection();
               PreparedStatement consulta = null;
               ResultSet res = null;
              
               
               try {
                   String cadena = "SELECT * FROM usuarios where usuario = ? and password = ?";
                   consulta = conectar.prepareStatement(cadena);
                   consulta.setString(1, usu.getUsuario());
                   consulta.setString(2, usu.getPasswordUsuario());
     
                   res = consulta.executeQuery();

                   if(res.next()) {
                	   System.out.println(res.getString("nombre_usuario"));
                       estatus = true;
                   }
   
     
               } catch (SQLException e) {
                   System.out.println(e);
               }finally{
                   try {
                       if(consulta != null) consulta.close();
                       if(res != null) res.close();
                  
                   }catch(Exception e){
                       System.out.println(e);  
                   }
               }
               conec.desconectar();
               return estatus;
               }
    
}
