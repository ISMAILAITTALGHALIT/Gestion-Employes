<%@page import="com.ensa.entity.Employe"%>
<%@page import="com.ensa.service.impl.TachesServiceImpl"%>
<%@page import="com.ensa.dao.impl.TachesDaoImpl"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ensa.dao.TachesDao"%>
<%@ page import="com.ensa.entity.Taches"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Vos taches</title>
</head>
<style>
body{
background-color:#E6E5E3;
font-family:Verdana, Geneva, sans-serif;
}
table{
padding-top:50px;
}
th{
 height: 50px;
 width:100px;
 padding: 15px;
 text-align: center;
}
td{
 padding: 15px;
 text-align: center;
}
</style>
<body>
	<%
		EmployeDaoImpl emp = new EmployeDaoImpl();
// 		TachesServiceImpl t = new TachesServiceImpl();
		TachesDaoImpl t = new TachesDaoImpl();		
Employe e = emp.findByEmail((String) session.getAttribute("emp_email"));
	%>
	<div class="row">
	>
	<p style="padding-left:30px;"> Mr <%= session.getAttribute("emp_nom") %> 
	<%= session.getAttribute("emp_prenom") %> 
	
<div class="offset-md-7 ">
	<a href='profile.jsp' class="btn btn-outline-secondary">Mon profile</a>
	<a href='index.html' class="btn btn-outline-secondary">Deconnecter</a></p>
	</div>
	</div>
	
	
	<h1 align="center">Liste de vos taches:</h1>
	<br>
	<table align='center' border='2px'>
		<tr>
			<th>Id</th>
			<th>Charge_Horaire</th>
			<th>Priorité</th>
			<th>Status</th>
			<th>Projet</th>
			<th>edit</th>
		</tr>
	<% List<Taches> list = t.findTachesByEmploye(e); %>
		<% for (Taches tache : list) { %>
		<tr>
			<td><%=tache.getId_tache()%></td>
			<td><%=tache.getCharge_horaire_tache() %></td>
			<td><%=tache.getPriorite_tache()%></td>
			<td><%=tache.getStatut_tache()%></td>
			<td><%=tache.getProjet().getCode_pro()%></td>
			<td><a href="Edit.jsp?id_tache=<%=tache.getId_tache()%>">edit</a></td>
		</tr>
	<%}%>

	</table>
</body>
</html>