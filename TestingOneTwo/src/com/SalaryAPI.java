package com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalaryAPI
 */
@WebServlet("/SalaryAPI")
public class SalaryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryAPI() {
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
		Salary s=new Salary();
		
		String output = s.insertItem(request.getParameter("email"), 
				 request.getParameter("month"), 
				request.getParameter("year"), 
				request.getParameter("amount")
				); 
				response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		
		Salary s=new Salary();
		
		 String output = s.updateItem(paras.get("hidItemIDSave").toString(), 
		 paras.get("email").toString(), 
		paras.get("month").toString(), 
		paras.get("year").toString(), 
		paras.get("amount").toString()
		); 
		response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		myMap m=new myMap();
		Map paras = m.getParasMap(request); 
		
		Salary s=new Salary();
		
		 String output = s.deleteItem(paras.get("itemID").toString()); 
		response.getWriter().write(output); 
	}

}
