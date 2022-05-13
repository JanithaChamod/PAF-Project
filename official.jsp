<%@page import="com.Official"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managing Official Details</title>


<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="views/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="components/official.js"></script>




</head>
<body> 
1
<div class="container"><div class="row"><div class="col-6"> 
<h1>Official Details Management</h1>
<form id="formItem" name="formItem">
 First Name
 <input id="firstName" name="firstName" type="text" 
 class="form-control form-control-sm">
 <br> Last Name
 <input id="lastName" name="lastName" type="text" 
 class="form-control form-control-sm">
 <br> Date
 <input id="date" name="date" type="text" 
 class="form-control form-control-sm">
 <br> Gender 
 <input id="gender" name="gender" type="text" 
 class="form-control form-control-sm">
 <br>Father
 <input id="father" name="father" type="text" 
 class="form-control form-control-sm">
 <br>Mother
 <input id="mother" name="mother" type="text" 
 class="form-control form-control-sm">
 <br>Designation
 <input id="designation" name="designation" type="text" 
 class="form-control form-control-sm">
 <br>Department
 <input id="department" name="department" type="text" 
 class="form-control form-control-sm">
 
 
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 
 
 <input type="" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
Official of =new Official();
 out.print(of.readItems()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>
