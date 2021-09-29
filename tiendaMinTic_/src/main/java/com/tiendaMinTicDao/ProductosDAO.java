package com.TiendaWebDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tiendaDto.ProductosVO;

public class ProductosDAO {
	
public ArrayList<ProductosVO> listarProductos(){
		
		ArrayList<ProductosVO> listaProductos =new ArrayList<>();
		ConexionDB conex = new ConexionDB();
		
		try {
			String query="Select codigo_producto,ivacompra,nitproveedor, nombre_producto, precio_compra, precio_venta from productos;";
			PreparedStatement consulta =conex.getConexion().prepareStatement(query);
			ResultSet res=consulta.executeQuery();
			
			
			while(res.next()) {
				ProductosVO producto = new ProductosVO();
				producto.setCodigoProducto(res.getLong("codigo_producto"));
				producto.setIvaCompra(res.getDouble("ivacompra"));
				producto.setNitProveedor(res.getLong("nitproveedor"));
				producto.setNombreProducto(res.getString("nombre_producto"));
				producto.setPrecioCompra(res.getDouble("precio_compra"));
				producto.setPrecioVenta(res.getDouble("precio_venta"));
				listaProductos.add(producto);
			}
			res.close();
			consulta.close();
			
			conex.desconectar();
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return listaProductos;
	}
	
	 public ArrayList<ProductosVO>  buscarProducto(Long Id) {
	        ArrayList<ProductosVO> listaProductos = new ArrayList<>();
	        
	        ConexionDB conex = new ConexionDB();
	        
	          if (conex != null) {
	                String cadena = "";
	                boolean estatus=false;
	                
	                try {
	                	 cadena ="Select codigo_producto,ivacompra,nitproveedor, nombre_producto, precio_compra, precio_venta from productos where codigo_producto = ?;";
	                        PreparedStatement consulta = conex.getConexion().prepareStatement(cadena);
	                        consulta.setLong(1, Id);            
	  
	                         ResultSet res = consulta.executeQuery();
	                         while(res.next()){
	                        	 ProductosVO producto = new ProductosVO();
	             				 producto.setCodigoProducto(res.getLong("codigo_producto"));
	             				 producto.setIvaCompra(res.getDouble("ivacompra"));
	             				 producto.setNitProveedor(res.getLong("nitproveedor"));
	             				 producto.setNombreProducto(res.getString("nombre_producto"));
	             				 producto.setPrecioCompra(res.getDouble("precio_compra"));
	             				 producto.setPrecioVenta(res.getDouble("precio_venta"));
	             				 listaProductos.add(producto);
	                           }
	                          res.close();
	                          consulta.close();
							  if(listaProductos.size()>0){
								estatus=true;

							  }
	                          
	                          	          
	                 } catch (SQLException e) {
	                     System.out.println(e);
	                }finally{
	                   if (!estatus) {
	                	   listaProductos =  null;
	                    }
	                 }
	          }
	        conex.desconectar(); 
	        return listaProductos;
	        
	   }

	   public boolean registrarProducto(ProductosVO prod) {
	        
		boolean estatus = false;
		ConexionDB conex=new ConexionDB();
		 if (conex != null && prod != null) { 
			 try {
				 String cadena = "INSERT INTO productos (`codigo_producto`, `ivacompra`, "
						  + "`nitproveedor`,`nombre_producto`, `precio_compra`, `precio_venta`) VALUES ("+"'"+ prod.getCodigoProducto()+"'"+","
						  +"'"+prod.getIvaCompra()+"'"+","
						  +"'"+prod.getNitProveedor()+"'"+","
						  +"'"+prod.getNombreProducto()+"'"+","
						  +"'"+prod.getPrecioCompra()+"'"+","
						  +"'"+prod.getPrecioVenta()+"'"
						  +")";

			PreparedStatement consulta = conex.getConexion().prepareStatement(cadena);
						 
				  if (this.buscarProducto(prod.getCodigoProducto()) == null) {  // si el producto no esxiste registra producto
						consulta.executeUpdate(cadena);
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


	 public boolean modificarProducto(ProductosVO prod) {
		boolean estatus=false;
		ConexionDB conex=new ConexionDB();
		try{
			String cadena ="UPDATE producto SET ivacompra = ?,nitproveedor = ?, nombre_producto = ?, precio_compra = ?,"
					+ "precio_venta = ? WHERE codigo_producto = ? ";
			PreparedStatement consulta = conex.getConexion().prepareStatement(cadena);
			
			consulta.setDouble(1, prod.getIvaCompra());
			consulta.setLong(2, prod.getNitProveedor()); 
			consulta.setString(3, prod.getNombreProducto());
			consulta.setDouble(4, prod.getPrecioCompra());
			consulta.setDouble(5, prod.getPrecioVenta());
			consulta.setLong(6, prod.getCodigoProducto()); 
 

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

	 /**
	 * Elimina un producto de la base de datos usado el codigo_producto
	 * @param est Objeto tipo DTO que contiene los datos del producto a  eliminar
	 * @return boolean true: si existe producto, flase si no exite
	 */
	public boolean eliminarProducto(Long Id) {
		ConexionDB conex=new ConexionDB();
		 boolean estatus=false;
		 
		try {
			String cadena = "DELETE FROM productos WHERE codigo_producto ='"+Id+"'";
			PreparedStatement consulta = conex.getConexion().prepareStatement(cadena);
			if(consulta.executeUpdate(cadena) == 1){
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
