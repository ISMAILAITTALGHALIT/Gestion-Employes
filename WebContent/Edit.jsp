<%@page import="com.ensa.service.impl.TachesServiceImpl"%>
<%@page import="com.ensa.dao.impl.TachesDaoImpl"%>
<%@page import="com.ensa.entity.Taches"%>
<%@page import="com.ensa.dao.impl.EmployeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Edit</title>
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
	<p style="padding-left:30px;">
		Mr
		<%=session.getAttribute("emp_nom")%>
		<%=session.getAttribute("emp_prenom")%>
		<div class="offset-md-8 ">
		<a href='profile.jsp' class="btn btn-outline-secondary">Mon profile</a> <a href='index.html' class="btn btn-outline-secondary">Deconnecter</a>
	</p>
</div></div>

	<%
// 		TachesServiceImpl temp = new TachesServiceImpl();
	TachesDaoImpl temp = new TachesDaoImpl();
	%>
	<%
		Taches tache = temp.findById(Integer.parseInt(request.getParameter("id_tache")));
	%>
<div class="row">
<div class="col-md-8 offset-md-3 ">
	<form method="Post" action="TacheServlet">
	<h1 style="padding-right:0px;">Vous étes en train d'éditer la tache</h1>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Id tache</label> <input type="text"
					class="form-control" id="inputEmail4" name="id"
					value="<%=tache.getId_tache()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Code projet</label> <input type="text"
					class="form-control" id="inputPassword4"
					value="<%=tache.getProjet().getCode_pro()%>">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Charge Horaire</label> <input type="text"
					class="form-control" id="inputEmail4"
					value="<%=tache.getCharge_horaire_tache()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Priorité</label> <input type="text"
					class="form-control" id="inputPassword4"
					value="<%=tache.getPriorite_tache()%>">
			</div>
		</div>
		<div class="form-group">
		<div class="form-group col-md-8">
			<label for="inputAddress">Description</label> <input type="text"
				class="form-control" id="inputAddress"
				value="<%=tache.getDescription_tache()%>">
		</div></div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="inputEmail4">Date debut</label> <input type="date"
					class="form-control" id="inputEmail4" name="dated"
					value="<%=tache.getDate_debut_tache()%>">
			</div>
			<div class="form-group col-md-4">
				<label for="inputPassword4">Date fin</label> <input type="date"
					class="form-control" id="inputPassword4" name="datef"
					value="<%=tache.getDate_fin_tache()%>" >
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
			<div class="form-group col-md-5">
			<div class="offset-md-4 ">
			
				<input class="btn btn-secondary" type="submit" name="editEmp" value="valider" >
			</div>
			</div>
		</div>
	</form>
</div></div>
	</div>


	</table>

</body>
</html>