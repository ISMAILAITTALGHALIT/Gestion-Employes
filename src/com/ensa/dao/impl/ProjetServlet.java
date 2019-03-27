package com.ensa.dao.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensa.entity.Projet;

/**
 * Servlet implementation class DeleteProjet
 */
@WebServlet("/ProjetServlet")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjetServlet() {
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
		ProjetDaoImpl projet = new ProjetDaoImpl();
		 if (request.getParameter("chercher") != null) {
			response.setContentType("text/html");
			Projet p=  projet.findById(request.getParameter("cher"));
			RequestDispatcher rd = request.getRequestDispatcher("resProjet.jsp");
			request.setAttribute("codep",p.getCode_pro());
			request.setAttribute("desc",p.getDescription_pro());
			request.setAttribute("charge",p.getCharge_horaire_pro());
			request.setAttribute("nom",p.getNom_pro());
			rd.forward(request, response);
		}else {
		ProjetDaoImpl projetImpl = new ProjetDaoImpl();
		Projet projet1 = projetImpl.findById(request.getParameter("id_projet"));
		projetImpl.delete(projet1);
		response.sendRedirect("Chef_de_projet.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProjetDaoImpl projet = new ProjetDaoImpl();
		
		PrintWriter out= response.getWriter();
		
		out.print(request.getParameter("editProjet"));

		if (request.getParameter("editProjet") != null) {

			projet.updateProjet(request.getParameter("code"), request.getParameter("nom"),
			request.getParameter("description"), Integer.parseInt(request.getParameter("charge")));
			
			
			
			response.sendRedirect("Chef_de_projet.jsp");

		} else if (request.getParameter("addP") != null) {
			projet.addProjet(request.getParameter("code"), Integer.parseInt(request.getParameter("charge")),
					request.getParameter("desc"), request.getParameter("nom"),
					Integer.parseInt(request.getParameter("chef")));
			response.sendRedirect("Chef_de_projet.jsp");
		}
		

	}

}
