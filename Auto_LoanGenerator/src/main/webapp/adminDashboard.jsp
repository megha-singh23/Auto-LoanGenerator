<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.autoloan.model.User" %>
<%@ page import="com.autoloan.model.Loan" %>
<%@ page import="com.autoloan.dao.LoanDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fasten</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container ">
        <img src="img/logo.png" height="30px" class="mr-2">
            <a class="navbar-brand text-black" href="#">Fasten</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto text-black">
                  <% User user=new User();
		if(session!=null) {
			user=(User)session.getAttribute("user");
		}
        if(user.getEmail()!=null){ %>
        	<li><span class='text-white'>Welcome <%=user.getName()%></span></li>
        	<li><a href="LogOutController"><button class="btn btn-warning me-2" type="button">LogOut</button></a></li>

     <%  			
        }
        else {
        	%>
        <li><a href="login.jsp"><button class="btn btn-outline-success me-2" type="button">Login</button></a></li>
        <li><a href="register.jsp"><button class="btn btn-success" type="button">Register</button></a></li>
		<%
        }
        %>
                </ul>
            </div>
        </div>
    </nav> <% 
    LoanDAO dao=new LoanDAO();
		List<Loan> allloans=dao.getAllLoans();
		%>
				<h1 class="text-center"> Admin Dashboard </h1>
				<div class="mx-auto">
				<table class="table table-striped" border='1'>
				<thead class="table-dark">
				<tr>
		<%	
		String[] columns=dao.getColumnName();
		for(String col:columns) {
			%>
			<td><%=col%></td>
			<%
		}
		%>
		<td class='text-center'> Action</td>
		</tr></thead><tbody>
		<% 
		for(Loan loan: allloans) {
			%>
			<tr>
			<td><%=loan.getLoanId()%></td>
			<td><%=loan.getUserId()%></td>
			<td><%=loan.getCarModel()%></td>
			<td><%=loan.getLoanAmount()%></td>
			<td><%=loan.getTenure()%></td>
			<td><%=loan.getInterestRate()%></td>
			<td><%=loan.getEmi()%></td>
			<td><%=loan.getStatus()%></td>
			<td style='display:flex; gap:20px;'>
			<button class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#editModal' onclick='fillModal(this)'> Edit</button>
			<a href='DeleteController?id="+student.getId()+"'><button class='btn btn-danger' data-bs-toggle='modal' data-bs-target='#exampleModal'> Delete</button></a></td>
		<% } %>
		</tr></tbody>
				</table>
				</div>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<div class="modal fade" id="editModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<form class="row g-3" action="EditController" method="get">
        	<div class="col-md-12">
        		<label for="id" class="form-label">LoanId</label>
        		<input type="text" class="form-control" id="id" name="id" disabled>
        		<input type='hidden' id='id2' name="id">
      		</div>
      <div class="col-md-6">
        <label for="id" class="form-label">UserId</label>
        <input type="text" class="form-control" id="id3" name="id">
      	<input type='hidden' id='id4' name="id">
      </div>
      <div class="col-md-6">
        <label for="model" class="form-label">CarModel</label>
        <input type="text" class="form-control" name="model" id="model">
        
      </div>
      <div class="col-md-6">
        <label for="amount" class="form-label">LoanAmount</label>
        <input type="number" class="form-control" name="amount" id="amount" > 
      </div>
      <div class="col-md-6">
        <label for="tenure" class="form-label">Tenure</label>
        <input type="number" class="form-control" id="tenure" name="tenure">
        <input type='hidden' id='tenure1' name="tenure">
      </div>
      <div class="col-md-6">
        <label for="interestrate" class="form-label">Interest Rate</label>
        <input type="number" class="form-control" name="interestrate" id="interestrate">
      </div>
      <div class="col-md-6">
        <label for="emi" class="form-label">Emi</label>
        <input type="number" class="form-control" name="emi" id="emi">
        <input type='hidden' id='emi1' name="emi">
        
      </div>
      <div class="col-md-6">
        <label for="status" class="form-label">Status</label>
        <input type="text" class="form-control" name="status" id="status">
       	<input type='hidden' id='status1' name="status">
        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-primary">Edit</button>
      </div>
       		</form>
    	</div>
  	</div>
  </div>
</div>

<script>
	function fillModal(e)
	{
	   const tr=e.parentNode.parentNode;
	   console.log(tr);
	   console.dir(tr);
	   const tdArr=tr.childNodes;
	   document.querySelector("#id").value=tdArr[0].textContent;
	   document.querySelector("#id2").value=tdArr[0].textContent;
	   document.querySelector("#id3").value=tdArr[1].textContent;
	   document.querySelector("#id4").value=tdArr[1].textContent;
	   document.querySelector("#model").value=tdArr[2].textContent;
	   document.querySelector("#Amount").value=tdArr[3].textContent;
	   document.querySelector("#tenure").value=tdArr[4].textContent;
	   document.querySelector("#tenure1").value=tdArr[4].textContent;
	   document.querySelector("#interestrate").value=tdArr[5].textContent;
	   document.querySelector("#emi").value=tdArr[6].textContent;
	   document.querySelector("#emi1").value=tdArr[6].textContent;
	   document.querySelector("#status").value=tdArr[7].textContent;
	   document.querySelector("#status1").value=tdArr[7].textContent;
	}
</script>
</body>
</html>