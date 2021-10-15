package com.tiendaMinTicDto;

public class ClienteVO {
	private Long  cedulaCliente;
	private String nombreCompleto;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	
	
	public ClienteVO() {};
	
	public Long getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(Long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public void setDefault() {
		this.cedulaCliente = (long) 0;
		this.nombreCompleto="";
		this.direccion="";
		this.telefono="";
		this.correoElectronico="";
		
	}

}
