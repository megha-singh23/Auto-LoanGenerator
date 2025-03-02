<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Auto Loan</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-card {
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            overflow: hidden;
        }
        .card-header {
            font-size: 20px;
            font-weight: bold;
            padding: 15px;
        }
        .form-control {
            border-radius: 8px;
        }
        .btn-custom {
            background: #2575fc;
            border: none;
            padding: 10px;
            font-size: 18px;
            border-radius: 8px;
            transition: 0.3s;
        }
        .btn-custom:hover {
            background: #1d5bd7;
        }
        .register-link a {
            text-decoration: none;
            color: #2575fc;
            font-weight: 500;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card login-card">
                    <div class="card-header text-center bg-primary text-white">Login</div>
                    <div class="card-body">
                        <form action="LoginServlet" method="post">
                        
                       <%  String msg=(String)request.getAttribute("msg");
								if(msg!=null) {
										out.print(msg);
									}  
						%>
                            <div class="mb-3">
                                <label class="form-label">Email:</label>
                                <input type="email" name="email" class="form-control" required placeholder="Enter your email">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password:</label>
                                <input type="password" name="password" class="form-control" required placeholder="Enter your password">
                            </div>
                            <button type="submit" class="btn btn-custom w-100">Login</button>
                        </form>
                        <div class="text-center mt-3 register-link">
                            <a href="register.jsp">Don't have an account? Register</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
