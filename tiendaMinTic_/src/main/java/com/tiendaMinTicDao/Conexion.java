package com.tiendaMinTicDao;
import java.sql.*;

import javax.swing.JOptionPane;
public class Conexion {
	
	static String bd="tiendaGenerica";
	static String login="root";
	static String password="";
	static String  url="jdbc:mysql://localhost/"+bd; 
	

	
	Connection connection= null;
	
	
	public Conexion() {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,login,password);}
		catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	
	public void desconectar() {
		connection= null;
		
	}
	
	
	
	
}



