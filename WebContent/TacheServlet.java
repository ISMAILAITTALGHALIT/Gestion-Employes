package com.ensa.dao.impl;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensa.entity.Employe;
import com.ensa.entity.Taches;
import com.ensa.service.impl.TachesServiceImpl;

/**
 * Servlet implementation class TachhServlet
 */
@WebServlet("/TacheServlet")
public class TacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TacheServlet() {
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
		TachesDaoImpl tachedao = new TachesDaoImpl();
		Taches tache = tachedao.findById(Integer.parseInt(request.getParameter("id_tache")));
		tachedao.delete(tache);
		response.sendRedirect("Chef_de_projet.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeDaoImpl e = new EmployeDaoImpl();
		//TachesServiceImpl t= new TachesServiceImpl();
		
		TachesDaoImpl t=new TachesDaoImpl();
		
		if (request.getParameter("editEmp") != null) {
			Date dated = Date.valueOf(request.getParameter("dated"));
			Date datef = Date.valueOf(request.getParameter("datef"));
			t.updateTache(Integer.parseInt(request.getParameter("id")),dated,datef,request.getParameter("status"));
			response.sendRedirect("Employe.jsp");
		}else if (request.getParameter("editChef")!= null) {
			Date dated = Date.valueOf(request.getParameter("datedebut"));
			Date datef = Date.valueOf(request.getParameter("datefin"));
			t.updateTache(Integer.parseInt(request.getParameter("id")),dated,datef,request.getParameter("status"),request.getParameter("description"),Integer.parseInt(request.getParameter("charge")),Integer.parseInt(request.getParameter("priorite")),e.findById(Integer.parseInt(request.getParameter("Employe"))));
			response.sendRedirect("Chef_de_projet.jsp");
		}else if (request.getParameter("ajouterTache") != null) {
			TachesDaoImpl tachedao = new TachesDaoImpl();
			
			Date dated = Date.valueOf(request.getParameter("dated"));
			Date datef = Date.valueOf(request.getParameter("datef"));
			EmployeDaoImpl empl = new EmployeDaoImpl();
			ProjetDaoImpl pImp = new ProjetDaoImpl();
			tachedao.addTache(Integer.parseInt(request.getParameter("charge")),dated, datef, request.getParameter("desc"),Integer.parseInt(request.getParameter("prio")),request.getParameter("status"),empl.findById(Integer.parseInt(request.getParameter("Employe"))),pImp.findById(request.getParameter("projet")));
			
			response.sendRedirect("Chef_de_projet.jsp");

		}
	}

}
