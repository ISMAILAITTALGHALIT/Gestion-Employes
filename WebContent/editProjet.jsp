<%@page import="com.ensa.entity.Projet"%>
<%@page import="com.ensa.dao.impl.ProjetDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Edit projet</title>
</head>

<style>
body{
margin:0;
padding:0;
background-color:#EDEBE8;
}
.form-control{
  position: relative;
 display: inline-block;
  font-family: "Open Sans", sans;
    outline: 0;
  text-indent: 70px;
  transition: all .3s ease-in-out;

 border-radius:20px;
   border:2px solid #ccc; 
}
</style>

<body>
		<%
			ProjetDaoImpl p = new ProjetDaoImpl();
 			Projet  projet =   p.findById(request.getParameter("id_projet"));
		%>
		
		
		
<div class="row">
<div class="col-md-10 offset-md-3 ">

	<form method="Post" action="ProjetServlet">
	<br>
	<h1>Vous êtes en train d'éditer le projet </h1>
	<br>
		<div class="form-row">
			<div class="form-group col-md-5">
				<label for="inputEmail4">Code Projet</label> 
								<div class="col-sm-6">
				<input type="text"
					class="form-control" id="inputEmail4" name="code"
					value="<%=projet.getCode_pro()%>">
			</div>
			</div>
			<div class="form-group col-md-5">
				<label for="inputPassword4">nom projet</label>
								<div class="col-sm-6">
				 <input type="text"
					class="form-control" id="c" name="nom"
					value="<%=projet.getNom_pro()%>">
			</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-5">
				<label for="inputEmail4">Description Projet</label>
								<div class="col-sm-6">
				 <input type="text"
					class="form-control" id="ch" name="description"
					value="<%=projet.getDescription_pro()%>">
			</div>
			</div>
			<div class="form-group col-md-5">
				<label for="inputPassword4">Charge horaire</label> 
								<div class="col-sm-6">
				<input type="text"
					class="form-control" id="inputPassword4" name="charge"
					value="<%=projet.getCharge_horaire_pro()%>">
			</div>
			</div>
		</div>
		
		
	
		
<!-- 				<input type="submit" name="editProjet" value="valider" class="btn btn-secondary" style="padding-left:50px;"> -->
		
		
		<div class="form-group row">
		<div class="col-sm-1 offset-md-3">
<input type="submit" name="editProjet" value="valider"  style="width:100px;">				</div></div>
		
	</form>
</div>
</div>



</body>
</html>