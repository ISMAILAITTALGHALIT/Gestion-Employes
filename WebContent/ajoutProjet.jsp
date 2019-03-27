<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Ajout projet</title>
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
<div class="col-md-10 offset-md-4 ">
	<form action="ProjetServlet" method="post">
	<br><div class="col-sm-10 "><h1 >Remplissez ce formulaire </h1></div></br>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">code</label>			<div class="col-sm-3">
			 <input type="text" name="code"
				class="form-control">
		</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">charge</label>
			<div class="col-sm-3">
				<input type="text" name="charge" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">description</label>
			<div class="col-sm-3">
				<input type="text" name="desc" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">nom</label>
			<div class="col-sm-3">

				<input type="text" name="nom" class="form-control">
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">chef du projet</label>
			<div class="col-sm-3">
				<input type="text" name="chef" class="form-control"
					value="<%=session.getAttribute("emp_id")%>">
			</div>
		</div>
<div class="row">
<div class="col-md-10 offset-md-3 ">
		<input type="submit" class="btn btn-info" name="addP" value="ajouter">
		</div>
		</div>
	</form>
	</div>
	</div>
</body>
</html>