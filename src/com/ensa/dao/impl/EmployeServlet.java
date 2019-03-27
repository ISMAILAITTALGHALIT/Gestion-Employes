package com.ensa.dao.impl;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeServlet
 */
@WebServlet("/EmployeServlet")
public class EmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeDaoImpl empl = new EmployeDaoImpl();
		empl.delete(empl.findById(Integer.parseInt(request.getParameter("id_empl"))));
		response.sendRedirect("Administrateur.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeDaoImpl empDao = new EmployeDaoImpl();
		if (request.getParameter("editEmpl") != null) {
			Date dn = Date.valueOf(request.getParameter("date"));
			empDao.updateEmpl(Integer.parseInt(request.getParameter("id")), request.getParameter("nom"),
					request.getParameter("prenom"), request.getParameter("role"), request.getParameter("emmail"), dn);
			response.sendRedirect("Administrateur.jsp");
		} else if (request.getParameter("ajouterE") != null) {
			Date d = Date.valueOf(request.getParameter("daten"));
			EquipeDaoImpl eq = new EquipeDaoImpl();
			empDao.addEmplye(Integer.parseInt(request.getParameter("id")), request.getParameter("nom"),request.getParameter("prenom"), request.getParameter("role"), request.getParameter("emmail"),request.getParameter("password"), d, Integer.parseInt(request.getParameter("equipe")));
			response.sendRedirect("Administrateur.jsp");
		}

	}

}
