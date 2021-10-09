package com.tiendaMinTicDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VentasVO {
	
	@Id
	@Column(name = "codigo_venta")
	private long codigoVentas;
	
	@Column(name = "cedula_cliente")
	private long cedulaCliente;
	
	@Column(name = "cedula_usuario")
	private long cedulaUsuario;
	
	@Column(name = "ivaventa")
	private double ivaVenta;
	
	@Column(name = "total_venta")
	private double totalVenta;
	
	@Column(name = "valor_venta")
	private double valorVenta;

	public long getCodigoVentas() {
		return codigoVentas;
	}

	public void setCodigoVentas(long codigoVentas) {
		this.codigoVentas = codigoVentas;
	}

	public long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public double getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	
	

}
