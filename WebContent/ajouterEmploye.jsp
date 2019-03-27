<%@page import="com.ensa.entity.Equipe"%>
<%@page import="java.util.List"%>
<%@page import="com.ensa.dao.impl.EquipeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Ajout employe</title>
</head>
<style>
body{
background:#E3E9E4;
font-family:'HelveticaNeue','Arial', sans-serif;
}
.form{
           background: rgba(0,0,0,.2); 
           width:100%; 
           height:100%; 
           position: absolute; 
           top:0; 
           left:0;
           transition:all .3s ease;}
       .darken-bg{background: rgba(0,0,0,.5) !important; transition:all .3s ease;}
       display: block;
           width: 90%;
           height: 44px;
           padding: 5px 5%;
           border:1px solid #ccc;
           
           background-color: #fff;
           font-family:'HelveticaNeue','Arial', sans-serif;
       
}
</style>
<body>
<br><br>
<div class="row">
<div class="col-md-10 offset-md-4 ">

 	<form action="EmployeServlet" method="post" class="form">        
     <h1>Veuillez remplir vos informations</h1>
		<br>
		<div class="form-group row">
				<label for="input1" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-3">
 				<input type="text" class="form-control" name="id" />
				</div>
		</div>
		
		

		<div class="form-group row">
				<label for="input2" class="col-sm-2 col-form-label">Nom</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="nom" />
				</div>
		</div>
			
		
		<div class="form-group row">
				<label for="input3" class="col-sm-2 col-form-label">Prenom</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="prenom" />
				</div>
		</div>
		 
		 
		
		<div class="form-group row">
				<label for="input4" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-3">
					<input type="email" class="form-control" name="emmail" />
				</div>
		</div>
		
			
			<div class="form-group row">
				<label for="input4" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" name="password"  />
				</div>
			</div>
			

		<div class="form-group row">
				<label for="input5" class="col-sm-2 col-form-label">Date de naissance</label>
				<div class="col-sm-3">
					<input type="date" class="form-control" name="daten" />
				</div>
			</div>

		<div class="form-group row">
			<label for="input6" class="col-sm-2 col-form-label">Role</label>
			<div class="col-sm-3">
				<select name="role" class="form-control">
					<option value="Employe">Employe</option>
					<option value="Administrateur">Admin</option>
					<option value="Chef de projet">chef</option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="input7" class="col-sm-2 col-form-label">Equipe</label>
			<div class="col-sm-3">
				<select name="equipe" class="form-control">
			<% EquipeDaoImpl e = new EquipeDaoImpl(); 
 					 List<Equipe> equipes = e.findAll(); %>
					<%
 									for (Equipe ez : equipes) { 
							%> 
					<option value="<%=ez.getCode_equipe()%>"><%= ez.getNom_equipe() %></option>
					<%
 									} 
						%> 
				</select>
			</div>
		</div>
	<div class="form-group row">
		<div class="col-sm-1 offset-md-3">
			<input class="btn btn-secondary" type="submit" name="ajouterE" value="ajouter" class="form-control">
		</div>
	</div>
	</form> 
</div>
</div>

</body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>