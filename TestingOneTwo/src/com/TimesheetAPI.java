package com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimesheetAPI
 */
@WebServlet("/TimesheetAPI")
public class TimesheetAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesheetAPI() {
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
		Timesheet t=new Timesheet();
		String output = t.insertItem(request.getParameter("email"), 
				 request.getParameter("workTitle"), 
				request.getParameter("workDescription"), 
				request.getParameter("total"),
				request.getParameter("date")
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
		
	Timesheet t=new Timesheet();
		
		 String output = t.updateItem(paras.get("hidItemIDSave").toString(), 
		 paras.get("email").toString(), 
		paras.get("workTitle").toString(), 
		paras.get("workDescription").toString(), 
		paras.get("total").toString(),
		paras.get("date").toString()
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
		
	Timesheet t=new Timesheet();
		
		 String output = t.deleteItem(paras.get("itemID").toString()); 
		response.getWriter().write(output); 
	}

}
