package com; 
import java.sql.*; 
public class Official
{ 
private Connection connect() 
 { 
 Connection con = null; 
 try
 { 
 Class.forName("com.mysql.cj.jdbc.Driver"); 
 con = 
 DriverManager.getConnection( 
 "jdbc:mysql://127.0.0.1:3306/manpower", "root", ""); 
 } 
 catch (Exception e) 
 { 
 e.printStackTrace(); 
 } 
 return con; 
 } 
public String readItems() 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for reading."; 
 } 
 // Prepare the html table to be displayed
 output = "<table border='1'><tr><th>First Name</th> <th>Last Name</th><th>Date</th>"+ "<th>Gender</th>  <th>Father</th><th>Mother</th><th>Designation</th><th>Department</th><th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from cusofficial"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String itemID = Integer.toString(rs.getInt("empID")); 
 String firstName = rs.getString("fName"); 
 String lastName = rs.getString("lName"); 
 String date = rs.getString("date");
 String myGender = rs.getString("gender");
 String myFather= rs.getString("father");
 String myMother = rs.getString("mother");
 String myDesignation = rs.getString("designation");
 String myDept = rs.getString("department"); 
 
 
 
 // Add into the html table
output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + itemID
 + "'>" + firstName + "</td>"; 
 output += "<td>" + lastName + "</td>"; 
 output += "<td>" + date + "</td>"; 
 output += "<td>" + myGender + "</td>"; 
 output += "<td>" + myFather + "</td>"; 
 output += "<td>" + myMother + "</td>"; 
 output += "<td>" + myDesignation + "</td>"; 
 output += "<td>" + myDept + "</td>"; 
 // buttons
//buttons
output += "<td><input name='btnUpdate' type='button' value='Update' "
+ "class='btnUpdate btn btn-secondary' data-itemid='" + itemID + "'></td>"
+ "<td><input name='btnRemove' type='button' value='Remove' "
+ "class='btnRemove btn btn-danger' data-itemid='" + itemID + "'></td></tr>"; 
; 
 } 
 con.close(); 
 // Complete the html table
 output += "</table>"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while reading the items."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String insertItem(String a, String b, 
 String c, String d,String e,String f,String g, String h) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for inserting."; 
 } 
 // create a prepared statement
 String query = " insert into cusofficial(`empID`,`fName`,`lName`,`date`,`gender`,`father`,`mother`,`designation`,`department`)"
 
 + " values (?, ?, ?, ?, ?,?,?,?,?)"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, 0); 
 preparedStmt.setString(2, a); 
 preparedStmt.setString(3, b); 
 preparedStmt.setString(4, c); 
 preparedStmt.setString(5, d); 
 preparedStmt.setString(6, e); 
 preparedStmt.setString(7, f); 
 preparedStmt.setString(8, g); 
 preparedStmt.setString(9, h); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readItems(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception ex) 
 { 
 output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
 System.err.println(ex.getMessage()); 
 } 
 return output; 
 } 
public String updateItem(String a, String b, String c, 
 String d, String e,String f,String g,String h,String i) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for updating."; 
 } 
 // create a prepared statement
 String query = "UPDATE cusofficial SET fName=?,lName=?,date=?,gender=?,father=?,mother=?,designation=?,department=? WHERE empID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, b); 
 preparedStmt.setString(2, c); 
 preparedStmt.setString(3, d); 
 preparedStmt.setString(4, e);
 preparedStmt.setString(5, f);
 preparedStmt.setString(6, g);
 preparedStmt.setString(7, h);
 preparedStmt.setString(8, i); 
 
 preparedStmt.setInt(9, Integer.parseInt(a)); 
 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readItems(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception ex) 
 { 
 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
 System.err.println(ex.getMessage()); 
 } 
 return output; 
 } 
public String deleteItem(String empID) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 { 
 return "Error while connecting to the database for deleting."; 
 } 
 // create a prepared statement
 String query = "delete from cusofficial where empID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(empID)); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readItems(); 
 output = "{\"status\":\"success\", \"data\": \"" + 
 newItems + "\"}"; 
 } 
 catch (Exception e) 
 { 
 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
}
