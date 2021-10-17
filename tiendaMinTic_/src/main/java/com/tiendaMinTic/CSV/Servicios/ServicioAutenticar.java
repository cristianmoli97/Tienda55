package com.tiendaMinTic.CSV.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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


        public ArrayList<UsuariosVO> consultarUsername(String username){
                ArrayList<UsuariosVO> listaUsuarios= new ArrayList<> ();
                Conexion conex=new Conexion();
                
                 if (conex != null) {
                            String query = "";
                            boolean estatus=false;
                try {
                    query="Select cedula_usuario, usuario from usuarios where usuario=?";
                    PreparedStatement consulta=conex.getConnection().prepareStatement(query);
                    consulta.setString(1,username);
                    ResultSet res=consulta.executeQuery();
                    
                    
                    if (res.next()) {
                        UsuariosVO usuario=new UsuariosVO();
                        usuario.setCedula(res.getInt("cedula_usuario"));
                        usuario.setUsuario(res.getString("usuario"));
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
    
}
