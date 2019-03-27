<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.ensa.entity.Projet" %>
<%@ page import="com.ensa.dao.ProjetDao" %>
<%@ page import="com.ensa.dao.impl.ProjetDaoImpl" %>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Chef de projet</title>
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
 height: 50px;
 width:100px;
 padding: 10px;
 text-align: center;
}
td{
 padding: 1px;
 text-align: center;
}

</style>
<body>



<div class="row">

	<p style="padding-left:30px;">  Mr <%= session.getAttribute("emp_nom") %> <%= session.getAttribute("emp_prenom") %> 
		
</p>	
		
		<% 
		
		
		ProjetDaoImpl p = new ProjetDaoImpl();
 		List<Projet> list = p.findProjetByEmpId((int) session.getAttribute("emp_id"));
		
		%>

<div class="offset-md-6 ">
		<a class="btn btn-outline-secondary" href='profile.jsp'>Mon profile</a>
		<a class="btn btn-outline-secondary" href='index.html'>Deconnecter</a></p>
	
</div>
</div>	
	
	
		<h1 align="center">Liste des taches:</h1><br>
	<table align='center' border='2px'>
		<tr>
			<th>Id</th>
			<th>Charge_Horaire</th>
			<th>Priorité</th>
			<th>Status</th>
	 		<th>Taches du projet</th>
	 		<th>edit</th>
			<th>Status</th>
		</tr>
		<% for (Projet projet : list) { %>
		<tr>
			<td><%=projet.getCode_pro()%></td>
			<td><%=projet.getNom_pro() %></td>
			<td><%=projet.getDescription_pro()%></td>
			<td><%=projet.getCharge_horaire_pro()%></td>
 			<td><a href="listTaches.jsp?id_projet=<%=projet.getCode_pro()%>">Liste_taches</a></td>
			<td><a href="editProjet.jsp?id_projet=<%=projet.getCode_pro()%>">Edit</a></td> 
			<td><a href="ProjetServlet?id_projet=<%=projet.getCode_pro()%>">Delete</a></td> 

		</tr>
	<%}%>


	</table>
		
	

<br>
<div class="row">
<div class="col-md-4 offset-md-4 ">


<form action="ProjetServlet" mathod="get">
  <div class="form-row">
    <div class="col-4">
<input type="text" name="cher" placeholder="code tache" class="form-control mb-1">
    </div>
    <div class="col">
<input type="submit" name="chercher" value="chercher" class="btn btn-primary">
    </div>
    <div class="col-md-5 ">
 
<a href="ajoutProjet.jsp" class="btn btn-success"  >Ajouter Projet</a>
   
    </div>
  </div>
</form>
</div>
</div>

</body>
</html>