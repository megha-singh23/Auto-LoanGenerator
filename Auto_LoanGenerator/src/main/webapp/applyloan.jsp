<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.autoloan.model.User" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apply for Loan</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <img src="img/logo.png" height="30px" class="mr-2">
        <a class="navbar-brand text-black" href="index.jsp">Fasten</a>
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
                    <li><span class='text-white'>Welcome <%= user.getName() %></span></li>
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

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header text-center bg-info text-white">Apply for Auto Loan</div>
                    <div class="card-body">
                        <form action="ApplyLoanServlet" method="post">
                            <div class="mb-3">
                                <label>Car Model:</label>
                                <input type="text" name="carModel" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label>Loan Amount:</label>
                                <input type="number" name="loanAmount" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label>Tenure (Months):</label>
                                <input type="number" name="tenure" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label>Interest Rate (%):</label>
                                <input type="number" name="interestRate" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-info w-100">Submit Application</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
