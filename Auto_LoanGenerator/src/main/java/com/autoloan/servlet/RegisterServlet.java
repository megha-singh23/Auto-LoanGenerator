package com.autoloan.servlet;
import com.autoloan.dao.UserDAO;
import com.autoloan.model.User;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        double income = Double.parseDouble(request.getParameter("income"));

        User user = new User(0, name, email, password, income);
        
        UserDAO init=new UserDAO();
        int status=init.registerUser(user);
        if (status>0) 
        {
            response.sendRedirect("login.jsp");
        } else 
        {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
