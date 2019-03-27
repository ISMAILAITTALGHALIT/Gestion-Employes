<%@page import="com.ensa.entity.Employe"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.ensa.dao.impl.EquipeDaoImpl"%>
<%@page import="com.ensa.entity.Equipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit employe</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
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
	<br>
	<% EmployeDaoImpl empl = new EmployeDaoImpl();%>
	<%	Employe em = empl.findById(Integer.parseInt(request.getParameter(("id_empl")))); %>
	<br>
	<div class="row">
		<div class="col-md-10 offset-md-4 ">

			<form class="form-horizontal" role="form" method="post"
				action="EmployeServlet">
				<fieldset class="legend-brdr-bttm">
					<legend style="padding-left:110px;">
						<strong>Profile à éditer</strong>
					</legend><br>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Nom</label>
						<div class="col-sm-3">
							<input type="text" name="nom" class="form-control"
								value="<%= em.getNom_empl()%>"
								 />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Prenom</label>
						<div class="col-sm-3">
							<input type="text" name="prenom" class="form-control"
								value="<%=em.getPrenom_empl()%>"
								 />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Id</label>
						<div class="col-sm-3">
							<input type="text" name="id" class="form-control"
								value="<%=em.getId_empl()%>"
								 />
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Date
							de naissance</label>
						<div class="col-sm-3">
							<input type="text" name="date" class="form-control"
								value="<%=em.getDate_naissance_empl()%>"
								 />
						</div>
					</div>


					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-3">
							<input type="text" name="emmail" class="form-control"
								value="<%=em.getEmail_empl()%>"
								 />
						</div>
					</div>

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Role</label>
						<div class="col-sm-3">
							<select name="role" class="form-control">
								<option value="Employe">Employe</option>
								<option value="Administrateur">Admin</option>
								<option value="Chef de projet">chef</option>
							</select>
						</div>
					</div>


					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Equipe</label>
						<div class="col-sm-3">
							<select name="role" class="form-control">
							<% EquipeDaoImpl e = new EquipeDaoImpl(); %>
							<% List<Equipe> equipes = e.findAll(); %>
								<%
									for (Equipe ee : equipes) {
								%>
								<option value="<%=ee.getCode_equipe()%>"><%= ee.getNom_equipe() %></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
<div class="form-group row">
<div class="row">
<div class="offset-md-10 col-md-3">
					<div class="form-group col-md-6">
						<input type="submit" name="editEmpl" value="valider" class=" btn btn-secondary" style="width:120px;">
					</div></div></div></div>
			</form>
		</div>
	</div>
</body>
</html>