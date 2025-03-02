package com.autoloan.model;

public class Loan {
   
	private int loanId;
    private int userId;
    private String carModel;
    private double loanAmount;
    private int tenure;
    private double interestRate;
    private double emi;
    private String status;

    public Loan(int loanId, int userId, String carModel, double loanAmount, int tenure, double interestRate,double emi, String status) {
        this.loanId = loanId;
        this.userId = userId;
        this.carModel = carModel;
        this.loanAmount = loanAmount;
        this.tenure = tenure;
        this.interestRate = interestRate;
        this.emi=emi;
        this.status = status;
    }
    
    public Loan() {
    	
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getEmi() {
        return emi;
    }

    public void setEmi(double interestRate) {
        this.emi = emi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
   	public String toString() {
   		return "Loan [loanId=" + loanId + ", userId=" + userId + ", carModel=" + carModel + ", loanAmount=" + loanAmount
   				+ ", tenure=" + tenure + ", interestRate=" + interestRate + ", emi=" + emi + ", status=" + status + "]";
   	}
}
