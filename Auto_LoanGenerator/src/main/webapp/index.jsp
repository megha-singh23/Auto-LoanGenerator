<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.autoloan.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fasten</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	<link rel="icon" type="image/png" href="img/logo.png">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <img src="img/logo.png" height="30px" class="mr-2">
        <a class="navbar-brand text-black" href="#">Fasten</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto text-black">
                <%
                HttpSession sess = request.getSession(false); // Get existing session (don't create a new one)
                User user = null;
                
                if (sess != null) {
                    user = (User) sess.getAttribute("user"); // Retrieve user object from session
                }

                if (user != null && user.getEmail() != null) { 
                %>
                    <li><span class='text-black'>Welcome <%= user.getName() +" "%></span></li>
                    <li><a href="LogOutController"><button class="btn btn-warning me-2" type="button">LogOut</button></a></li>
                <%
                } else {
                %>
                    <li><a href="login.jsp"><button class="btn btn-outline-success me-2" type="button">Login</button></a></li>
                    <li><a href="register.jsp"><button class="btn btn-success" type="button">Register</button></a></li>
                <%
                }
                %>
            </ul>
        </div>
    </div>
</nav>

    <div class="container text-center mt-5">
        <h1>Welcome to Auto Loan System</h1>
        <p>Apply for loans easily and get quick approvals.</p>
        <a href="register.jsp" class="btn btn-success">Get Started</a>
        <br>
        <br>
        <p>Apply for loan By Fasten</p>
        <a href="applyloan.jsp" class="btn btn-success">Loan</a>
   </div>
</body>
</html>
