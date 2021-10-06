package com.tiendaMinTicDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tiendaMinTicDto.ProveedoresVO;



public class ProveedoresDAO {
	//lo que sea
	public ArrayList<ProveedoresVO> listarProveedores(){			
			ArrayList<ProveedoresVO> listaProveedores =new ArrayList<>();			
			Conexion conex=new Conexion();			
			try {				
				String query="SELECT nitproveedores,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor FROM proveedores;";
				PreparedStatement consulta =conex.getConnection().prepareStatement(query);
				ResultSet res=consulta.executeQuery();				
				while(res.next()) {
					ProveedoresVO proveedor=new ProveedoresVO();
					proveedor.setNitProveedor(res.getLong("nitproveedores"));
					proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
					proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
					proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
					proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
					listaProveedores.add(proveedor);
				}
				res.close();
				consulta.close();
				conex.desconectar();				
			} catch (Exception e) {				
				System.out.println("Error listarProveedores..."+e);
			}			
			return listaProveedores;
		}
	
	public ArrayList<ProveedoresVO> buscarProveedor(long nitProveedor){
		ArrayList<ProveedoresVO> listaProveedores = new ArrayList<>();
		Conexion conex = new Conexion();
		try {
			String query ="SELECT nitproveedores,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor FROM proveedores WHERE nitproveedores = ?";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setLong(1, nitProveedor);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				ProveedoresVO proveedor = new ProveedoresVO();
				proveedor.setNitProveedor(res.getLong("nitproveedores"));
				proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
				proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
				proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
				proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
				listaProveedores.add(proveedor);
			}
			else
				listaProveedores=null;
			res.close();
			consulta.close();
			conex.desconectar();
		} catch(Exception e) {
			System.out.println("Error buscarProveedor..."+e);
		}
		return listaProveedores;
	}
	
	public boolean registarProveedor (ProveedoresVO proveedor) { 
		Conexion conex = new Conexion();
		try {
			String query = "INSERT INTO proveedores (nitproveedores,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			statement.setLong(1,proveedor.getNitProveedor());
			statement.setString(2,proveedor.getCiudadProveedor());
			statement.setString(3,proveedor.getDireccionProveedor());
			statement.setString(4, proveedor.getNombreProveedor());
			statement.setString(5, proveedor.getTelefonoProveedor());
			int result = statement.executeUpdate();
			statement.close();
			conex.desconectar();			
			return result > 0;
		} catch (Exception e) {			
			return false;
		}		
	}
	
	public boolean actualizarProveedor (ProveedoresVO proveedor) {
		Conexion conex = new Conexion();
		try {
			String query = "UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ? WHERE nitproveedores = ?";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			statement.setString(1, proveedor.getCiudadProveedor());
			statement.setString(2, proveedor.getDireccionProveedor());
			statement.setString(3, proveedor.getNombreProveedor());
			statement.setString(4, proveedor.getTelefonoProveedor());
			statement.setLong(5, proveedor.getNitProveedor());
			int result = statement.executeUpdate();
			statement.close();
			conex.desconectar();
			return result > 0;
		} catch (Exception e) {			
			return false;
		}
	}
	
	public boolean eliminarProveedor (Long nitProveedor) {
		Conexion conex = new Conexion();
		try {
			String query = "DELETE FROM proveedores WHERE nitproveedores = ?";
			PreparedStatement statement = conex.getConnection().prepareStatement(query);
			statement.setLong(1, nitProveedor);
			int result = statement.executeUpdate();
			statement.close();
			conex.desconectar();
			return result > 0;
			
		} catch (Exception e) {			
			return false;
		}
	}
}
