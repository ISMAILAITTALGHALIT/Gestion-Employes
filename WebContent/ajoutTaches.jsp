<%@page import="com.ensa.dao.impl.ProjetDaoImpl"%>
<%@page import="com.ensa.entity.Projet"%>
<%@page import="com.ensa.dao.impl.TachesDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ensa.entity.Employe"%>
<%@page import="java.util.List"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>

<%@page import="com.ensa.entity.Taches"%>
<%@page import="com.ensa.dao.impl.TachesDaoImpl"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Ajout d'une tache</title>
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
<br><br>
<div class="row">
<div class="col-md-10 offset-md-4 ">
<h1>Remplisser ce formulaire</h1><br>
	<form action="TacheServlet" method="post">

		<%
			EmployeDaoImpl e = new EmployeDaoImpl();
			List<Employe> listEmp = e.getEmployes();
		%>

		<%
			ProjetDaoImpl pd = new ProjetDaoImpl();
			Projet p = pd.findById(request.getParameter("id_p"));
		%>




		<div class="form-group row">

		<label class="col-sm-2 col-form-label">Charge horaire </label><div class="col-sm-3"> <input class="form-control" type="text" name="charge"></div>
		</div> 		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Date
			debut</label><div class="col-sm-3"> <input  style="padding:0px;" class="form-control" type="date" name="dated"></div>
		</div>		<div class="form-group row">
		 <label class="col-sm-2 col-form-label">Date fin</label><div class="col-sm-3"> <input
			type="date" name="datef" class="form-control" style="padding:0px;">	</div>
		</div>	<div class="form-group row">
			 <label class="col-sm-2 col-form-label">Description</label> <div class="col-sm-3"><input
			type="text" name="desc" class="form-control"> </div>
		</div>		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Priorite</label> <div class="col-sm-3"><input
			type="text" name="prio" class="form-control"> 	</div>
		</div>	
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Status</label>
			<div class="col-sm-3">
<!-- 			<div class="form-group col-md-6"> -->
			 <select
			name="status" class="form-control">
			<option value="a faire">a faire</option>
			<option value="en cours">en cours</option>

			<option value="termine">termine</option>


		</select> 
		</div>	</div>	
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Employe </label>
			<div class="col-sm-3">
				<select name="Employe" class="form-control">
					<%
						for (Employe empl : listEmp) {
					%>
					<option value="<%=empl.getId_empl()%>"><%=empl.getNom_empl()%></option>
					<%
						}
					%>
				</select>
			</div></div>
			<div class="form-group row">
			<label class="col-sm-2 col-form-label">Projet</label> 
			<div class="col-sm-3">
			<input class="form-control" type="text" name="projet"
				value="<%=request.getParameter("id_p")%>">
		</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-1 offset-md-3">
				<input  class="btn btn-secondary" type="submit" name="ajouterTache" value="ajouter" >
				</div></div>
	</form></div></div>
</body>
</html>