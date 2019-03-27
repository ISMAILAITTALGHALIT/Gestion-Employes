<%@page import="com.ensa.entity.Employe"%>
<%@page import="java.util.List"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Page d'administrateur</title>
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


<div class="row">

	<p style="padding-left:30px;">  Mr <%= session.getAttribute("emp_nom") %> <%= session.getAttribute("emp_prenom") %> 
		 
</p>	
		

<div class="offset-md-7 ">
		<a class="btn btn-outline-secondary" href='profile.jsp'>Mon profile</a>
		<a class="btn btn-outline-secondary" href='index.html'>Deconnecter</a></p>
	
</div>
</div>	

<%

EmployeDaoImpl empIm = new EmployeDaoImpl();
List<Employe> employes = empIm.findAll();

%>
<center>

	<h1 style="text-align:center;font-family:Verdana, Geneva, sans-serif	;">Liste des employés</h1><br>
	<table align='center' border='2px' style="border-collapse: collapse;border: 1px solid black;">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Role</th>
			<th>Email</th>
			<th>Date de Naissance</th>
			<th>Edit</th>		
			<th>Delete</th>	
			
			
		</tr>
		
		<%
		for(Employe emp : employes){
		%>
		<tr>
			<td><%=emp.getId_empl()%></td>
			<td><%=emp.getNom_empl()%></td>
			<td><%=emp.getPrenom_empl()%></td>
			<td><%=emp.getRole_empl()%></td>
			<td><%=emp.getEmail_empl()%></td>
			<td><%=emp.getDate_naissance_empl()%></td>		
			<td><a href="editEmploye.jsp?id_empl=<%=emp.getId_empl() %>">Edit</a></td>
			<td><a href="EmployeServlet?id_empl=<%=emp.getId_empl() %>">Delete</a></td>
			
			
		</tr>
		
		</center>

  
<%} %>
</table>
<br>
<br>
<div>
<a href="ajouterEmploye.jsp" style="padding:15px 15px;border:1px solid grey;background:grey;text-decoration:none;color:white;">ajouter employe</a>
</div>

</body>

</html>