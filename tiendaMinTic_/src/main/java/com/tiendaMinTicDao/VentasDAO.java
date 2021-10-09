package com.tiendaMinTicDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tiendaMinTicDto.VentasVO;



public class VentasDAO {

	public ArrayList<VentasVO> listarVentas(){
		ArrayList<VentasVO> listaventas= new ArrayList<>() ;
		Conexion conex=new Conexion();
		try {
			String query="Select codigo_venta,cedula_cliente,cedula_usuario,ivaventa,total_venta, valor_venta from ventas";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			while(res.next()) {
				VentasVO ventas =new VentasVO();
				ventas.setCodigoVentas(res.getLong("codigo_venta"));
				ventas.setCedulaCliente(res.getLong("cedula_cliente"));
				ventas.setCedulaUsuario(res.getLong("cedula_usuario"));
				ventas.setIvaVenta(res.getDouble("ivaventa"));
				ventas.setTotalVenta(res.getDouble("total_venta"));
				ventas.setValorVenta(res.getDouble("valor_venta"));
				listaventas.add(ventas);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		}catch (Exception e) {
			System.out.println("Erroro listar..." + e);
		}
		return listaventas;
			
	}
	
	
	public ArrayList<VentasVO> consultarVentas(long id){
		ArrayList<VentasVO> listaVentas= new ArrayList<> ();
		Conexion conex=new Conexion();
		 if (conex != null) {
	                String query = "";
	                boolean estatus=false;
		try {
			query="Select codigo_venta,cedula_cliente,cedula_usuario,ivaventa,total_venta, valor_venta from ventas where  codigo_venta=?";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			consulta.setLong(1,id);
			ResultSet res=consulta.executeQuery();
			
			
			if (res.next()) {
				VentasVO ventas =new VentasVO();
				ventas.setCodigoVentas(res.getLong("codigo_venta"));
				ventas.setCedulaCliente(res.getLong("cedula_cliente"));
				ventas.setCedulaUsuario(res.getLong("cedula_usuario"));
				ventas.setIvaVenta(res.getDouble("ivaventa"));
				ventas.setTotalVenta(res.getDouble("total_venta"));
				ventas.setValorVenta(res.getDouble("valor_venta"));
				listaVentas.add(ventas);
			}
			
			res.close();
			consulta.close();
			
			  if(listaVentas.size()>0){
				estatus=true;

			 }
			
		}catch(Exception e) {
			System.out.println("Error consultarPersona..."+e);
		}finally{
	           if (!estatus) {
	        	   listaVentas =  null;
		   }
		}
	}
	
		conex.desconectar();
		return listaVentas;
	}


	public boolean registrarVenta(VentasVO venta){
		boolean estatus = false;
		Conexion conex=new Conexion();
		if (conex != null && venta != null) { 
		try {
			String query = "insert into ventas (codigo_venta,cedula_cliente,cedula_usuario,ivaventa,total_venta, valor_venta)"
			 + "values (?,?,?,?,?)";

			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setLong(1, venta.getCodigoVentas());
			consulta.setLong(2,venta.getCedulaCliente());
			consulta.setLong(3, venta.getCedulaUsuario());
			consulta.setDouble(4, venta.getIvaVenta());
			consulta.setDouble(5,venta.getTotalVenta());
			consulta.setDouble(6,venta.getValorVenta());
		

			if (this.consultarVentas(venta.getCodigoVentas()) == null) {  // si la venta no esxiste registra venta
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
	
	
	public boolean modificarVentas(VentasVO venta) {
		boolean estatus=false;
		Conexion conex=new Conexion();
		try{         
			String query ="UPDATE ventas SET cedula_cliente = ?, cedula_usuario = ?, ivaventa = ?, total_venta = ? , valor_venta = ? WHERE codigo_venta = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			
			
			consulta.setLong(1,venta.getCedulaCliente());
			consulta.setLong(2, venta.getCedulaUsuario());
			consulta.setDouble(3, venta.getIvaVenta());
			consulta.setDouble(4,venta.getTotalVenta());
			consulta.setDouble(5,venta.getValorVenta());
			consulta.setLong(6, venta.getCodigoVentas());
			

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

	
	public boolean eliminarventa(long codigoVenta) {
		Conexion conex=new Conexion();
		 boolean estatus=false;
		 
		try {
			String query = "DELETE FROM ventas WHERE codigo_venta ='"+codigoVenta+"'";
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
