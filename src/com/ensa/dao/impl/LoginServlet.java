package com.ensa.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ensa.entity.Employe;
import com.ensa.service.impl.EmployeServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email= request.getParameter("name").toString();
        String password= request.getParameter("password").toString();
        
        EmployeServiceImpl emp= new EmployeServiceImpl();
        Boolean isConnected = emp.seConnecter(email,password);

		
        
       if(isConnected==true){
    	   
        EmployeDaoImpl employeImpl = new EmployeDaoImpl();
   		Employe employe = employeImpl.findByEmail(email);
    	   
    	   
    	   HttpSession session=request.getSession();  
           session.setAttribute("emp_email",employe.getEmail_empl());  
           session.setAttribute("emp_nom",employe.getNom_empl());  
           session.setAttribute("emp_prenom",employe.getPrenom_empl());  
           session.setAttribute("emp_role",employe.getRole_empl());  
           session.setAttribute("emp_date_naissance",employe.getDate_naissance_empl());  
           session.setAttribute("emp_id",employe.getId_empl());  

          
    	   
    	   // response.sendRedirect("ViewServlet");
    	   String role= employeImpl.findRole(email);
   		
    	   
   		if (role.equals("Administrateur")) {
   	           response.sendRedirect("Administrateur.jsp");
   		}
   		else if(role.equals("Chef de projet")) {
   	           response.sendRedirect("Chef_de_projet.jsp");
   		}
   		else if(role.equals("Employe")) {
   	           response.sendRedirect("Employe.jsp");
   		}else {
   			System.out.println("le role doit etre soit: Administrateur, Chef de projet, Employé"); 
   		}
    	   
    	   
    }
     else if (isConnected==false)
     {
       //response.sendRedirect("ViewServlet");
   	 // RequestDispatcher dispatcher = request.getRequestDispatcher("ViewServlet.java");
			//dispatcher.include(request,response);
    	 response.sendRedirect("indexErr.html");

     }

		//doGet(request, response);
	}

	

}
