package com.autoloan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.autoloan.dao.UserDAO;
import com.autoloan.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		HttpSession sess=request.getSession(false);
		if(sess==null) {
			request.setAttribute("msg","Please!! Login First");
//			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDAO dao=new UserDAO();
        User user = dao.getUserByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
//        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        if (user != null && user.getPassword().equals(password)) {
            response.sendRedirect("index.jsp");
        } else {
        	out.print("""
        			<div class="alert alert-danger" role="alert">
        	  Incorrect Password
        	</div>
        			""");
        }
        request.getRequestDispatcher("login.jsp").include(request,response);
    }
}