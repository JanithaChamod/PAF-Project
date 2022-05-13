package com; 
import java.sql.*; 
public class Leave
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
public String readContactDetails() 
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
 output = "<table border='1'><tr><th>Employee Email</th> <th>Leave Description</th><th>Leave Starting Date</th>"+ "<th>Leave Ending Date</th>  <th>Leave Status</th><th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from cusleave"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String itemID = Integer.toString(rs.getInt("leaveID")); 
 String email = rs.getString("empEmail"); 
 String reason = rs.getString("leaveDescription"); 
 String from = rs.getString("fromLeave");
 String to= rs.getString("toLeave");
 String status = rs.getString("leaveStatus");

 
 
 
 // Add into the html table
output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + itemID
 + "'>" + email + "</td>"; 
 output += "<td>" + reason+ "</td>"; 
 output += "<td>" + from + "</td>"; 
 output += "<td>" + to + "</td>"; 
 output += "<td>" +status+ "</td>"; 
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
 String c, String d,String e) 
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
 String query = " insert into cusleave(`leaveID`,`empEmail`,`leaveDescription`,`fromLeave`,`toLeave`,`leaveStatus`)"
 
 + " values (?, ?, ?, ?, ?,?)"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, 0); 
 preparedStmt.setString(2, a); 
 preparedStmt.setString(3, b); 
 preparedStmt.setString(4, c); 
 preparedStmt.setString(5, d); 
 preparedStmt.setString(6, e); 

 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readContactDetails(); 
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
 String d, String e,String f) 
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
 String query = "UPDATE cusleave SET empEmail=?,leaveDescription=?,fromLeave=?,toLeave=? ,leaveStatus=?  WHERE leaveID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, b); 
 preparedStmt.setString(2, c); 
 preparedStmt.setString(3, d); 
 preparedStmt.setString(4, e);
 preparedStmt.setString(5,f);
 
 preparedStmt.setInt(6, Integer.parseInt(a)); 
 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readContactDetails(); 
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
 String query = "delete from cusleave where leaveID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(empID)); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 String newItems = readContactDetails(); 
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

