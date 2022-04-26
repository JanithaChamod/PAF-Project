package com.electrogrid.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;


import com.electrogrid.model.Solar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("/solar")
public class SolarService {
	
	Solar solartObj = new Solar();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readSolarDetails() {
		return solartObj.readSolarDetails();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertSolarDetails(@FormParam("customername") String customername,
			@FormParam("paneltype") String paneltype, @FormParam("generatepower") String generatepower,
			@FormParam("noOfPanels") String noOfPanels) {
		String output = solartObj.insertSolarDetails(customername, paneltype, generatepower, noOfPanels);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateSolarDetails(String customername) {
		// Convert the input string to a JSON object
		JsonObject solarObject = new JsonParser().parse(customername).getAsJsonObject();
		// Read the values from the JSON object
		String ID = solarObject.get("ID").getAsString();
		String customerName = solarObject.get("customerName").getAsString();
		String panelType = solarObject.get("panelType").getAsString();
		String generatePower = solarObject.get("generatePower").getAsString();
		String noOfPanels = solarObject.get("noOfPanels").getAsString();
		String output = solartObj.updateSolarDetails(ID, customerName, panelType, generatePower, noOfPanels);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteSolarDetails(String customername) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(customername, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String ID = doc.select("ID").text();
		String output = solartObj.deleteSolarDetails(ID);
		return output;
	}
}
