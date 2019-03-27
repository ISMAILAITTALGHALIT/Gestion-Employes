package com.ensa.dao.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensa.dao.EmployeDao;
import com.ensa.dao.TachesDao;
import com.ensa.entity.Employe;
import com.ensa.entity.Taches;


/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
	
		response.setContentType("text/html");
		/*
		 List<Taches> list=TachesDao.findAll(); 
		
		out.print("<a href='index.html'>Deconnecter</a>");
		
		System.out.println("c bien");
		
		out.print("<h1>Liste des taches:</h1>");
		out.print("<table align='center' border='2px'><tr><th>Reference</th><th>Description</th><th>Volume</th><th>Heures Enseignés</th><th>Delete</th></tr>");
		for (Taches tache : list) {
			out.print("<tr><td>"+tache.getId_tache()+"</td><td>"+tache.getCharge_horaire_tache()+"</td><td>"+tache.getPriorite_tache()+"</td><td>"+tache.getStatut_tache()+"</td><td>"+tache.getProjet()+"</td>"+"<td><a href='EditServlet?id_tache="+tache.getId_tache()+"'>edit</a></td></tr>");
		}
		out.print("</table>");
		*/
		}
	
	
		// TODO Auto-generated method stub

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email= request.getParameter("name").toString();

		EmployeDaoImpl employe = new EmployeDaoImpl();
		
		
		String role= employe.findRole(email);
		
		if (role == "Administrateur") {
	           response.sendRedirect("Administrateur.jsp");
		}
		else if(role == "Chef de projet") {
	           response.sendRedirect("Chef_de_projet.jsp");
		}
		else if(role == "Employé") {
	           response.sendRedirect("Employé.jsp");
		}else {
			System.out.println("le role doit etre soit: Administrateur, Chef de projet, Employé"); 
		}
		
		doGet(request, response);
	}

}
