<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Votre profile</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
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
<br><br>
<div class="row">
<div class="col-md-10 offset-md-4 ">

	<form class="form-horizontal" role="form" method="get" action="#">
		<fieldset class="legend-brdr-bttm">
		
			<legend style="padding-left:150px;"><strong>Mon profile</strong></legend>
			<br>
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" 
						value="<%=session.getAttribute("emp_nom")%>"   />
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label" >Prenom</label>
				<div class="col-sm-3">
					<input type="text" class="form-control"
						value="<%=session.getAttribute("emp_prenom")%>" />
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label"  >Id</label>
				<div class="col-sm-3">
					<input type="text" class="form-control"
						value="<%=session.getAttribute("emp_id")%>" />
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label" >Date de naissance</label>
				<div class="col-sm-3">
					<input type="text" class="form-control"
						value="<%=session.getAttribute("emp_date_naissance")%>"  >
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label" >Email</label>
				<div class="col-sm-3">
					<input type="text" class="form-control"
						value="<%=session.getAttribute("emp_email")%>" />
				</div>
			</div>
			
			
		</form>
		</div>
		</div>
</body>
</html>