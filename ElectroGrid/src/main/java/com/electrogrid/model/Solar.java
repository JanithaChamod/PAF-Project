package com.electrogrid.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Solar {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// insert method
	public String insertSolarDetails(String customername, String paneltype, String generatepower, String noOfPanels) {
		Connection con = connect();
		String output = "";
		if (con == null) {
			return "Error while connecting to the database";

		}

		// create a prepared statement
		String query = " insert into solar (`ID`,`customerName`,`panelType`,`generatePower`,`noOFPanels`)"
				+ " values (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, customername);
			preparedStmt.setString(3, paneltype);
			preparedStmt.setString(4, generatepower);
			preparedStmt.setString(5, noOfPanels);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (SQLException e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// read method
	public String readSolarDetails() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Customer Name</th><th>Panel Type</th>" + "<th>Generate Power</th>"
					+ "<th>No Of Panels</th></tr>";

			String query = "select * from solar";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String ID = Integer.toString(rs.getInt("ID"));
				String customername = rs.getString("customername");
				String paneltype = rs.getString("paneltype");
				String generatepower = rs.getString("generatepower");
				String noOfPanels = rs.getString("noOfPanels");

				// Add into the html table
				output += "<tr><td>" + customername + "</td>";
				output += "<td>" + paneltype + "</td>";
				output += "<td>" + generatepower + "</td>";
				output += "<td>" + noOfPanels + "</td>";

			}
			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payment Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// update method
	public String updateSolarDetails(String ID, String customername, String paneltype, String generatepower, String noOfPanels)

	{
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = " update solar set customerName= ? , panelType = ? , generatePower = ? , noOfPanels = ?  where ID = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, customername);
			preparedStmt.setString(2, paneltype);
			preparedStmt.setString(3, generatepower);
			preparedStmt.setString(4, noOfPanels);
			preparedStmt.setInt(5, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Solar Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// delete method
	public String deleteSolarDetails(String ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from solar where ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the solar Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}

	


