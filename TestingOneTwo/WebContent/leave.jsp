<%@page import="com.Leave"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managing Leave Details</title>


<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="views/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="components/leave.js"></script>




</head>
<body> 

<div class="container"><div class="row"><div class="col-6"> 
<h1>Leave Details Management</h1>
<form id="formItem" name="formItem">
 Employee Email
 <input id="email" name="email" type="text" 
 class="form-control form-control-sm">
 <br> Leave Description
 <input id="leaveDesc" name="LeaveDesc" type="text" 
 class="form-control form-control-sm">
 <br> Leave Starting Date
 <input id="leaveStart" name="leaveStart" type="text" 
 class="form-control form-control-sm">
 <br> Leave Ending Date
 <input id="leaveEnd" name="leaveEnd" type="text" 
 class="form-control form-control-sm">
 <br> Leave Status
 <input id="status" name="status" type="text" 
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
	Leave l=new Leave();
 	out.print(l.readContactDetails()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>