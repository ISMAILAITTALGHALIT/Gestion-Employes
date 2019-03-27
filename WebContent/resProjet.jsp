<%@page import="com.ensa.entity.Projet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Tache</title>
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
 height: 30px;
 width:100px;
 padding: 5px;
 text-align: center;
}
td{
 padding: 1px;
 text-align: center;
}

</style>
<body>
<br><h1 align="center">Tache cherchée :</h1><br>
	<table align='center' border='2px'>
		<tr>
			<th>Code</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Charge</th>
	 		<th>Taches du projet</th>
	 		<th>edit</th>
			<th>Status</th>
		</tr>
		
		<tr>
			<td><%= request.getAttribute("codep") %></td>
			<td><%=request.getAttribute("nom") %></td>
			<td><%=request.getAttribute("desc")%></td>
			<td><%=request.getAttribute("charge")%></td>
 			<td><a href="listTaches.jsp?id_projet=<%=request.getAttribute("codep")%>">Liste_taches</a></td>
			<td><a href="editProjet.jsp?id_projet=<%=request.getAttribute("codep")%>">Edit</a></td> 
			<td><a href="ProjetServlet?id_projet=<%=request.getAttribute("codep")%>">Delete</a></td> 

		</tr>



	</table>
</body>
</html>