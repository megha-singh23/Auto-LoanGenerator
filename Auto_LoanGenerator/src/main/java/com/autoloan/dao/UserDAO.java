 package com.autoloan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.autoloan.model.User;

public class UserDAO {

	private static boolean isTableCreated=false;
	
	private void createTable() {
		
		try {
			Connection con=ConnectionProvider.getMySqlConnection();
			Statement st=con.createStatement();
			st.execute("""
					create table if not exists users(
					id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255),
					email VARCHAR(255) UNIQUE,
                    password VARCHAR(255),
                    income DOUBLE );
					""");
			isTableCreated=true;
			con.close();
			st.close();
			}
		catch(Exception e) {
				
			e.printStackTrace();
		}
	}
	 
	
	public UserDAO(){
		if(!isTableCreated) {
		createTable();
		System.out.println("table is created");
		}
	}
	public int registerUser(User user) {
		int rowsEffected=0;

		try {
		
		Connection con=ConnectionProvider.getMySqlConnection();
		PreparedStatement ps=con.prepareStatement("insert into users(name,email,password,income) values(?,?,?,?);");
		
		ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setDouble(4, user.getIncome());	
        
        System.out.println(ps);
		rowsEffected=ps.executeUpdate();
		ps.close();
		con.close();
		
        
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		return rowsEffected;
		
	}
	
	public static User getUserByEmail(String email) {
        try{
        	Connection con=ConnectionProvider.getMySqlConnection();
            PreparedStatement ps = con.prepareStatement("select * from users WHERE email = ?;");
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getDouble("income"));
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
	