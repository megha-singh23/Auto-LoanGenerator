package com.autoloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static Connection con=null;
	
	public static Connection getMySqlConnection() {
		
		final String URL="jdbc:mysql://localhost:3306/";
		final String DB="loanDB?createDatabaseIfNotExist=true";
		final String USERNAME="root";
		final String PASSWORD="1234";
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection(URL+DB,USERNAME,PASSWORD);
		System.out.println("connected to mysql successfully");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Unable to load "+ e.getLocalizedMessage());
		}
		catch(SQLException e) {
			System.out.println("SQL Error.. "+ e.getLocalizedMessage());
		}
		return con;
	}	
}
