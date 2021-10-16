package com.tiendaMinTicDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ledyn roman moreno castellanso
 *
 */

@Entity
@Table(name = "productos")
public class ProductosVO {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "codigo_producto")
	private long codigoProducto;
	
	@Column(name = "ivacompra")
	private double ivaCompra;
	
	@Column(name = "nitproveedor")
	private long nitProveedor;
	
	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	@Column(name = "precio_compra")
	private double precioCompra;
	
	@Column(name = "precio_venta")
	private double precioVenta;

	public long getCodigoProducto() {
		return codigoProducto;
	}
	
	

	public ProductosVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductosVO(long codigoProducto, double ivaCompra, long nitproveedor, String nombre_producto,
			double precio_compra, double precio_venta) {
		super();
		this.codigoProducto = codigoProducto;
		this.ivaCompra = ivaCompra;
		this.nitProveedor = nitproveedor;
		this.nombreProducto = nombre_producto;
		this.precioCompra = precio_compra;
		this.precioVenta = precio_venta;
	}


	public void setCodigoProducto(long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(long nitproveedor) {
		this.nitProveedor = nitproveedor;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombre_producto) {
		this.nombreProducto = nombre_producto;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precio_compra) {
		this.precioCompra = precio_compra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precio_venta) {
		this.precioVenta = precio_venta;
	}
	
	public void setDefault() {
		this.codigoProducto = 0;
		this.ivaCompra = 0;
		this.nitProveedor=0;
		this.nombreProducto="";
		this.precioCompra=0;
		this.precioVenta=0;
		
	}
	
	

}
