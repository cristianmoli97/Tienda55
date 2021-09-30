package com.tiendaMinTicDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tiendaMinTicDto.ProveedorVO;



public class ProveedorDao {
	
	public ArrayList<ProveedorVO> listarProveedores(){			
			ArrayList<ProveedorVO> listaProveedores =new ArrayList<>();			
			Conexion conex=new Conexion();			
			try {				
				String query="SELECT nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor FROM proveedores;";
				PreparedStatement consulta =conex.getConnection().prepareStatement(query);
				ResultSet res=consulta.executeQuery();				
				while(res.next()) {
					ProveedorVO proveedor=new ProveedorVO();
					proveedor.setNitProveedor(res.getLong("nitproveedor"));
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
	
	public ArrayList<ProveedorVO> buscarProveedor(long nitProveedor){
		ArrayList<ProveedorVO> listaProveedores = new ArrayList<>();
		Conexion conex = new Conexion();
		try {
			String query ="SELECT nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor FROM proveedores WHERE nitproveedor = ?";
			PreparedStatement consulta = conex.getConnection().prepareStatement(query);
			consulta.setLong(1, nitProveedor);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				ProveedorVO proveedor = new ProveedorVO();
				proveedor.setNitProveedor(res.getLong("nitproveedor"));
				proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
				proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
				proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
				proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
				listaProveedores.add(proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		} catch(Exception e) {
			System.out.println("Error buscarProveedor..."+e);
		}
		return listaProveedores;
	}
	
	public boolean registarProveedor (ProveedorVO proveedor) { 
		Conexion conex = new Conexion();
		try {
			String query = "INSERT INTO proveedores (nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor,telefono_proveedor) VALUES (?,?,?,?,?)";
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
	
	public boolean modificarProveedor (ProveedorVO proveedor) {
		Conexion conex = new Conexion();
		try {
			String query = "UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombre_proveedor = ?, telefono_proveedor = ? WHERE nitproveedor = ?";
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
			String query = "DELETE FROM proveedores WHERE nitproveedor = ?";
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
