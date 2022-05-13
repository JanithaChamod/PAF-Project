<%@page import="com.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Managing Contact Details</title>


<link rel="stylesheet" href="views/bootstrap.min.css">
<script src="views/bootstrap.min.css"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="components/contact.js"></script>




</head>
<body> 

<div class="container"><div class="row"><div class="col-6"> 
<h1>Contact Details Management</h1>
<form id="formItem" name="formItem">
 Current Address
 <input id="currentAddress" name="currentAddress" type="text" 
 class="form-control form-control-sm">
 <br> Permanent Address
 <input id="permanentAddress" name="permanentAddress" type="text" 
 class="form-control form-control-sm">
 <br> Your email
 <input id="email" name="email" type="text" 
 class="form-control form-control-sm">
 <br> Contact Number
 <input id="contactNumber" name="contactNumber" type="text" 
 class="form-control form-control-sm">
 <br>Higher Education
 <input id="higherEducation" name="higherEducation" type="text" 
 class="form-control form-control-sm">
 <br>Fluent language
 <input id="language" name="language" type="text" 
 class="form-control form-control-sm">
 <br>Primary Skill
 <input id="primarySkill" name="primarySkill" type="text" 
 class="form-control form-control-sm">
 <br>Secondary Skill
 <input id="secondarySkill" name="secondarySkill" type="text" 
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
Contact c=new Contact();
 out.print(c.readContactDetails()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>
