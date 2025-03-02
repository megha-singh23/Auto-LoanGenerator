package com.autoloan.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.autoloan.dao.LoanDAO;
import com.autoloan.model.Loan;

@WebServlet("/AdminLoanServlet")
public class AdminLoanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Loan> loans = LoanDAO.getAllLoans();
        request.setAttribute("loans", loans);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
