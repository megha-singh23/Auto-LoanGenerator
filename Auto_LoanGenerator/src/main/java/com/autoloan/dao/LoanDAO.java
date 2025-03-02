package com.autoloan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.autoloan.model.Loan;

public class LoanDAO {
	
private static boolean isTableCreated=false;
private static String columns[];
	
	private void createTable() {
		
		try {
			Connection con=ConnectionProvider.getMySqlConnection();
			Statement st=con.createStatement();
			st.execute("""
						create table if not exists loans(
						loanId INT PRIMARY KEY AUTO_INCREMENT,
                        userId INT, carModel VARCHAR(255),loanAmount DOUBLE,tenure INT,
                        interestRate DOUBLE,emi DOUBLE,status VARCHAR(50),
                        FOREIGN KEY (userId) REFERENCES users(id)");
					""");
			
			
			isTableCreated=true;
			con.close();
			st.close();
			}
		catch(Exception e) {
				
			e.printStackTrace();
		}
	}
	 
	
	public LoanDAO(){
		if(!isTableCreated) {
		createTable();
		}
	}
   
    public boolean applyLoan(Loan loan) {
        try {
        	Connection con=ConnectionProvider.getMySqlConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO loans(userId, carModel, loanAmount, tenure, interestRate, emi, status) VALUES (?, ?, ?, ?, ?, ?, ?);");
            ps.setInt(1, loan.getUserId());
            ps.setString(2, loan.getCarModel());
            ps.setDouble(3, loan.getLoanAmount());
            ps.setInt(4, loan.getTenure());
            ps.setDouble(5, loan.getInterestRate());
            ps.setDouble(6, loan.getEmi());
            ps.setString(7, "Pending");
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Loan> getLoansByUserId(int userId) {
        List<Loan> loans = new ArrayList<>();
        try {
        	Connection con=ConnectionProvider.getMySqlConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM loans WHERE userId = ?;");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loans.add(new Loan(rs.getInt("loanId"), rs.getInt("userId"), rs.getString("carModel"), rs.getDouble("loanAmount"), rs.getInt("tenure"), rs.getDouble("interestRate"),rs.getDouble("emi"), rs.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }


	public static List<Loan> getAllLoans() {
		
		List<Loan> loans=new ArrayList<>();
		try {
			Connection con=ConnectionProvider.getMySqlConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from loans;");
			
            ResultSetMetaData rsmd=rs.getMetaData();
			columns=new String[rsmd.getColumnCount()-1];
			for(int i=0;i<rsmd.getColumnCount()-1;i++) {
				columns[i]=rsmd.getColumnName(i+1);
			}
				
			while(rs.next()) {
				Loan temp=new Loan();
				temp.setLoanId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setCarModel(rs.getString(3));
				temp.setLoanAmount(rs.getDouble(4));
				temp.setTenure(rs.getInt(5));
				temp.setInterestRate(rs.getDouble(6));
				temp.setEmi(rs.getDouble(7));
				temp.setStatus(rs.getString(8));

				loans.add(temp);
				
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return loans;
	}
	
	public String[] getColumnName() {
		return columns;
	}
}
