<%@page import="com.ensa.entity.Employe"%>
<%@page import="java.util.List"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ensa.entity.Taches" %>
<%@page import="com.ensa.dao.impl.TachesDaoImpl" %>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Edit tache</title>
</head>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #EDEBE8;
}

.form-control {
	position: relative;
	display: inline-block;
	font-family: "Open Sans", sans;
	outline: 0;
	text-indent: 70px;
	transition: all .3s ease-in-out;
	border-radius: 20px;
	border: 2px solid #ccc;
}
</style>
<body>
<div class="row">
<p style="padding-left:50px;">
		Mr
		<%=session.getAttribute("emp_nom")%>
		<%=session.getAttribute("emp_prenom")%>
		<div class="offset-md-7 ">
		
		<a href='profile.jsp' class="btn btn-outline-secondary">Mon profile</a> <a href='index.html' class="btn btn-outline-secondary">Deconnecter</a></div></div>
	</p>

		<%
			TachesDaoImpl tt = new TachesDaoImpl();
 			Taches  tache =  tt.findById(Integer.parseInt(request.getParameter("id_tache")));
		%>
		
		<%
			EmployeDaoImpl e = new EmployeDaoImpl();
			List<Employe> listEmp = e.getEmployes();
		%>
		
	
<div class="row">
<div class="col-md-8 offset-md-3 " >
	<form method="Post" action="TacheServlet">
	<h1 style="padding-left:60px;">Remplissez ce formulaire</h1>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Id tache</label> <input type="text"
					class="form-control" id="inputEmail4" name="id"
					value="<%=tache.getId_tache()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Code projet</label> <input type="text"
					class="form-control" id="c" name="code"
					value="<%=tache.getProjet().getCode_pro()%>">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Charge Horaire</label> <input type="text"
					class="form-control" id="ch" name="charge"
					value="<%=tache.getCharge_horaire_tache()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Priorité</label> <input type="text"
					class="form-control" id="inputPassword4" name="priorite"
					value="<%=tache.getPriorite_tache()%>">
			</div>
		</div>
		<div class="form-group">
			<label for="inputAddress">Description</label><div class="form-group col-md-8"> <input type="text"
				class="form-control" id="descr" name="description" 
				value="<%=tache.getDescription_tache()%>">
		</div></div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Date debut</label> <input type="date"
					class="form-control" id="dd" name="datedebut"
					value="<%=tache.getDate_debut_tache()%>" style="padding:10px;">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Date fin</label> <input type="date"
					class="form-control" id="df" name="datefin"
					value="<%=tache.getDate_fin_tache()%>" style="padding:10px;">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<select name="status" class="form-control">
					<option value="a faire">a faire</option>
					<option value="en cours">en cours</option>
					<option value="terminé">terminé</option>
				</select>
			</div>
			
<!-- 			<div class="form-row"> -->
			<div class="form-group col-md-4">
				<select name="Employe" class="form-control">
					<% for(Employe empl : listEmp ){ %>
						<option value="<%= empl.getId_empl() %>"><%= empl.getNom_empl() %></option>
					<%} %>
				</select>
<!-- 			</div> -->
			</div>
			</div>
			
			<div class="row">
<div class="col-md-1 offset-md-3 " >
			<div class="form-group row">
			<div class="offset-md-3 ">
				<input class="btn btn-secondary" type="submit" name="editChef" value="valider" style="width:120px;">
			</div></div>
			</div></div>
		</div>
	</form>
</div></div>
	</div>


	</table>

</body>

</body>
</html>