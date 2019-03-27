<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ensa.dao.impl.TachesDaoImpl"%>
<%@ page import="com.ensa.entity.Taches"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Liste des taches</title>
</head>
<style>
body{
background-color:#E6E5E3;
font-family:Verdana, Geneva, sans-serif;
}
table{
padding-top:40px;
}
th{
 height: 10px;
 width:100px;
 padding: 8px;
 text-align: center;
}
td{
 padding: 8px;
 text-align: center;
}

</style>
<body>
<div class="row">
	<%
		TachesDaoImpl t = new TachesDaoImpl();
		List<Taches> list = t.findAllTachesByIdProject(request.getParameter("id_projet"));
	%>
	<div class="offset-md-9 ">
	<a href='profile.jsp' class="btn btn-outline-secondary">Mon profile</a>
	<a href='index.html' class="btn btn-outline-secondary">Deconnecter</a>
	</div>
	</div>
	</p>
<div class="row">
<div class="col-md-10 offset-md-4 ">
	<h1>Liste des taches:</h1><br>
	</div>
	</div>
	<table align='center' border='2px'>
		<tr>
			<th>Id</th>
			<th>Charge_Horaire</th>
			<th>Priorité</th>
			<th>Status</th>
			<th>Taches du projet</th>
			<th>Edit</th>
			<th>Delete</th>	
			
		</tr>
		<%
			for (Taches tache : list) {
		%>
		<tr>
			<td><%=tache.getId_tache()%></td>
			<td><%=tache.getCharge_horaire_tache()%></td>
			<td><%=tache.getPriorite_tache()%></td>
			<td><%=tache.getStatut_tache()%></td>
			<td><%=tache.getProjet().getCode_pro()%></td>
			<td><a href="editTaches.jsp?id_tache=<%=tache.getId_tache() %>">Edit</a></td>
			<td><a href="TacheServlet?id_tache=<%=tache.getId_tache() %>">Delete</a></td>
			
			
		</tr>
		<%
			}
		%>

	</table>
	<br>
	<div class="row">
<div class="col-md-10 offset-md-5 ">
	<a href="ajoutTaches.jsp?id_p=<%= request.getParameter("id_projet") %>" class="btn btn-secondary">Ajouter Projet</a>
	</div>
	</div>
</body>
</html>