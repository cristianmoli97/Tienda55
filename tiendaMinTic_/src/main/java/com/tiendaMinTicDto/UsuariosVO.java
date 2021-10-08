package com.tiendaMinTicDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UsuariosVO {
	@Id
	@Column(name = "cedula_usuario")
	private int Cedula;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "password")
	private String passwordUsuario;
	
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	
	@Column(name = "correo_usuario")
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
	public void setDefault() {
		this.Cedula = 0;
		this.usuario="";
		this.passwordUsuario="";
		this.nombreUsuario="";
		this.correoUsuario="";
		
	}

	
}
