<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Auto Loan</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card register-card">
                    <div class="card-header text-center bg-success text-white">Create Your Account</div>
                    <div class="card-body">
                        <form action="RegisterServlet" method="post">
                            <div class="mb-3">
                                <label class="form-label">Full Name:</label>
                                <input type="text" name="name" class="form-control" required placeholder="Enter your full name">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email:</label>
                                <input type="email" name="email" class="form-control" required placeholder="Enter your email">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password:</label>
                                <input type="password" name="password" class="form-control" required placeholder="Create a password">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Annual Income ($):</label>
                                <input type="number" name="income" class="form-control" required placeholder="Enter your annual income">
                            </div>
                            <button type="submit" class="btn btn-custom w-100">Register</button>
                        </form>
                        <div class="text-center mt-3 login-link">
                            <a href="login.jsp">Already have an account? Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
