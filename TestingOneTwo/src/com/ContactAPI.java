package com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactAPI
 */
@WebServlet("/ContactAPI")
public class ContactAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Contact c=new Contact();
		
		String output = c.insertItem(request.getParameter("currentAddress"), 
				 request.getParameter("permanentAddress"), 
				request.getParameter("email"), 
				request.getParameter("contactNumber"),
				request.getParameter("higherEducation"),
				request.getParameter("language"),
				request.getParameter("primarySkill"),
				request.getParameter("secondarySkill")); 
				response.getWriter().write(output); 
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		Contact c=new Contact();
		 String output = c.updateItem(paras.get("hidItemIDSave").toString(), 
		 paras.get("currentAddress").toString(), 
		paras.get("permanentAddress").toString(), 
		paras.get("email").toString(), 
		paras.get("contactNumber").toString(),
		paras.get("higherEducation").toString(),
		paras.get("language").toString(),
		paras.get("pimarySkill").toString(),
		paras.get("secondarySkill").toString()); 
		response.getWriter().write(output); 
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		
		Contact c=new Contact();
		
		 String output = c.deleteItem(paras.get("itemID").toString()); 
		response.getWriter().write(output); 
	}

}
