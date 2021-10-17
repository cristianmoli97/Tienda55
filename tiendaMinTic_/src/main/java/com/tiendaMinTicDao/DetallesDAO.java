package com.tiendaMinTicDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.tiendaMinTicDto.DetalleVO;


public class DetallesDAO {

	public ArrayList<DetalleVO> consultarDetallesVentas(long codigoDetalle){
		ArrayList<DetalleVO> listaDetallesVentas= new ArrayList<> ();
		Conexion conex=new Conexion();
		 if (conex != null) {
	                String query = "";
	                boolean estatus=false;
		try {
			query="Select * from detalle_ventas where codigo_detalle_venta=?";
			PreparedStatement consulta=conex.getConnection().prepareStatement(query);
			consulta.setLong(1,codigoDetalle);
			ResultSet res=consulta.executeQuery();
			
			
			if (res.next()) {
				DetalleVO Detallesventas = new DetalleVO();
				Detallesventas.setCodigo_detalle_venta(res.getLong("codigo_detalle_venta"));
				Detallesventas.setCantidad_producto(res.getLong("cantidad_producto"));
				Detallesventas.setCodigo_producto(res.getLong("codigo_producto"));
				Detallesventas.setCodigo_venta(res.getLong("codigo_venta"));
				Detallesventas.setValor_total(res.getDouble("valor_total"));
				Detallesventas.setValor_venta(res.getDouble("valor_venta"));
				Detallesventas.setValoriva(res.getDouble("valoriva"));
				listaDetallesVentas.add(Detallesventas);
			}
			
			res.close();
			consulta.close();
			
			  if(listaDetallesVentas.size()>0){
				estatus=true;

			 }
			
		}catch(Exception e) {
			System.out.println("Error consultarPersona..."+e);
		}finally{
	           if (!estatus) {
	        	   listaDetallesVentas =  null;
		   }
	           
		}
		
	}
			conex.desconectar();
			return listaDetallesVentas;
}
	
public boolean registrarDetalleVenta(DetalleVO detalle){
		
	boolean estatus = false;
	Conexion conex=new Conexion();
		if (conex != null && detalle != null) { 
			try {
							
		String query = "insert into detalle_ventas (`codigo_detalle_venta`, `cantidad_producto`, "
				  + "`codigo_producto`,`codigo_venta`, `valor_total`, `valor_venta`, `valoriva`) VALUES ("+"'"+ detalle.getCodigo_detalle_venta()+"'"+","
				  +"'"+detalle.getCantidad_producto()+"'"+","
				  +"'"+detalle.getCodigo_producto()+"'"+","
				  +"'"+detalle.getCodigo_venta()+"'"+","
				  +"'"+detalle.getValor_total()+"'"+","
				  +"'"+detalle.getValor_venta()+"'"+","
				  +"'"+detalle.getValoriva()+"'"
				  +")";
				
		PreparedStatement consulta = conex.getConnection().prepareStatement(query);

		if (this.consultarDetallesVentas(detalle.getCodigo_detalle_venta()) == null) {  // si la venta no existe registra venta
					consulta.executeUpdate(query);
					estatus =  true;
					System.out.print("imprimiooooooo");
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
			
}
