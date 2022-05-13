package com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OfficialAPI
 */
@WebServlet("/OfficialAPI")
public class OfficialAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficialAPI() {
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
		
		Official o=new Official();
		String output = o.insertItem(request.getParameter("firstName"), 
				 request.getParameter("lastName"), 
				request.getParameter("date"), 
				request.getParameter("gender"),
				request.getParameter("father"),
				request.getParameter("mother"),
				request.getParameter("designation"),
				request.getParameter("department")); 
				response.getWriter().write(output); 
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		Official o=new Official();
		 String output = o.updateItem(paras.get("hidItemIDSave").toString(), 
		 paras.get("firstName").toString(), 
		paras.get("lastName").toString(), 
		paras.get("date").toString(), 
		paras.get("gender").toString(),
		paras.get("father").toString(),
		paras.get("mother").toString(),
		paras.get("designation").toString(),
		paras.get("department").toString()); 
		response.getWriter().write(output); 
		
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		
		Official o=new Official();
		
		 String output = o.deleteItem(paras.get("itemID").toString()); 
		response.getWriter().write(output); 
		
	}

}
