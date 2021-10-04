package com.TiendawebDto;

public class UsuariosVO {
	private int Cedula;
	private String usuario;
	private String passwordUsuario;
	private String nombreUsuario;
	private String correoUsuario;
	public int getCedula() {
		return Cedula;
	}
	public void setCedula(int cedula) {
		Cedula = cedula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasswordUsuario() {
		return passwordUsuario;
	}
	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	
}
