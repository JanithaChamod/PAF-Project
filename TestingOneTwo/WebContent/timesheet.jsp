<%@page import="com.Timesheet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managing Timesheet Details</title>


<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="views/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="components/timesheet.js"></script>




</head>
<body> 

<div class="container"><div class="row"><div class="col-6"> 
<h1>Timesheet Details Management</h1>
<form id="formItem" name="formItem">
 Employee Email
 <input id="email" name="email" type="text" 
 class="form-control form-control-sm">
 <br> Work Title
 <input id="workTitle" name="workTitle" type="text" 
 class="form-control form-control-sm">
 <br> Work Description
 <input id="workDescription" name="workDescription" type="text" 
 class="form-control form-control-sm">
 <br> Total Work Hours
 <input id="total" name="total" type="text" 
 class="form-control form-control-sm">
 <br> Added Date
 <input id="date" name="date" type="text" 
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
	Timesheet t=new Timesheet();
 	out.print(t.readContactDetails()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>