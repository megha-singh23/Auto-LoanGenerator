package com.autoloan.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private double income;

    public User(int id, String name, String email, String password, double income) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.income = income;
    }
    
    public User(){
    	
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", income="
				+ income + "]";
	}
    
    
}