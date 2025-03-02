package com.autoloan.servlet;

import java.io.IOException;

import com.autoloan.dao.LoanDAO;
import com.autoloan.model.Loan;
import com.autoloan.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ApplyLoanServlet")
public class ApplyLoanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession sess=request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}
		User user = (User) sess.getAttribute("user");
		int userId = user.getId();
        String carModel = request.getParameter("carModel");
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        int tenure = Integer.parseInt(request.getParameter("tenure"));
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));

        double monthlyRate = (interestRate / 12) / 100;
        double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, tenure)) / (Math.pow(1 + monthlyRate, tenure) - 1);

        Loan loan = new Loan(0, userId, carModel, loanAmount, tenure, interestRate,emi, "Pending");
        LoanDAO init=new LoanDAO();
        HttpSession session = request.getSession();
        session.setAttribute("loan", loan);
        if (init.applyLoan(loan)) {
            response.sendRedirect("adminDashboard.jsp");
        } 
        else {
            response.sendRedirect("applyLoan.jsp?error=1");
        }
    }
}
