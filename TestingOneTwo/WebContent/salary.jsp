<%@page import="com.Salary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managing Salary Details</title>


<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="views/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="components/salary.js"></script>




</head>
<body> 

<div class="container"><div class="row"><div class="col-6"> 
<h1>Salary Details Management</h1>
<form id="formItem" name="formItem">
 Email
 <input id="email" name="email" type="text" 
 class="form-control form-control-sm">
 <br> Month
 <input id="month" name="month" type="text" 
 class="form-control form-control-sm">
 <br> Year
 <input id="year" name="year" type="text" 
 class="form-control form-control-sm">
 <br> Amount
 <input id="amount" name="amount" type="text" 
 class="form-control form-control-sm">
 
 
 
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 
 
 <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
	Salary s=new Salary();
 	out.print(s.readContactDetails()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>