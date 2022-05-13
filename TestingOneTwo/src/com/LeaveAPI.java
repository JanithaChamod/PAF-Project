package com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeaveAPI
 */
@WebServlet("/LeaveAPI")
public class LeaveAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveAPI() {
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
Leave l=new Leave();
		String output = l.insertItem(request.getParameter("email"), 
				 request.getParameter("leaveDesc"), 
				request.getParameter("leaveStart"), 
				request.getParameter("leaveEnd"),
				request.getParameter("leaveStatus")
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
		
		Leave l=new Leave();
		
		 String output = l.updateItem(paras.get("hidItemIDSave").toString(), 
		 paras.get("email").toString(), 
		paras.get("leaveDesc").toString(), 
		paras.get("leaveStartr").toString(), 
		paras.get("leaveEnd").toString(),
		paras.get("status").toString()
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
		
		Leave l=new Leave();
		
		 String output = l.deleteItem(paras.get("itemID").toString()); 
		response.getWriter().write(output); 
		
	}

}
