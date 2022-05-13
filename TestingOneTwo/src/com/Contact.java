package com; 
import java.sql.*; 
public class Contact
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
 output = "<table border='1'><tr><th>Current Address</th> <th>Permanent Address</th><th>Email</th>"+ "<th>Contact Number</th>  <th>Higher Education</th><th>Fluent Language</th><th>Primary Skill</th><th>Secondary Skill</th><th>Update</th><th>Remove</th></tr>"; 
 String query = "select * from cuscontact"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String itemID = Integer.toString(rs.getInt("conID")); 
 String cAddr = rs.getString("cAddr"); 
 String pAddr = rs.getString("pAddr"); 
 String myEmail = rs.getString("email");
 String contactNum = rs.getString("cNum");
 String higherEdu= rs.getString("highEdu");
 String lang = rs.getString("language");
 String primarySkill= rs.getString("pSkill");
 String secondarySkill = rs.getString("sSkill"); 
 
 
 
 // Add into the html table
output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + itemID
 + "'>" + cAddr + "</td>"; 
 output += "<td>" + pAddr + "</td>"; 
 output += "<td>" + myEmail + "</td>"; 
 output += "<td>" + contactNum + "</td>"; 
 output += "<td>" + higherEdu+ "</td>"; 
 output += "<td>" + lang+ "</td>"; 
 output += "<td>" + primarySkill + "</td>"; 
 output += "<td>" + secondarySkill + "</td>"; 
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
 String query = " insert into cuscontac(`conID`,`cAddr`,`pAddr`,`email`,`cNum`,`highEdu`,`language`,`pSkill`,`sSkill`)"
 
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
 String query = "UPDATE cuscontact SET cAddr=?,pAddr=?,email=?,cNum=?,highEdu=?,language=?,pSkill=?,sSkill=? WHERE conID=?"; 
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
 String query = "delete from cuscontact where conID=?"; 
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

