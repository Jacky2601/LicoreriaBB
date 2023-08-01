<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Licoreria Big Bang</title>

<link rel="stylesheet" 
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">

<link rel="stylesheet" 
	href="css/mis_estilos.css">

<style type="text/css"></style>

</head>
<body>

	<div id="login">
		<h1>Registrar Usuario</h1>
		<!-- Formulario -->
		<form action="crudUsu" method="post">
			<div class="form-group">
				<label for="inputNombre">Nombre:</label> <input name="txtNombre" class="form-control"
					id="inputNombre" placeholder="Ingrese su Nombre">
			</div>

			<div class="form-group">
				<label for="inputApellidoPaterno">Apellido Paterno:</label> <input name="txtApellidoPat"
					class="form-control" id="inputApellidoPaterno"
					placeholder="Ingrese su apellido paterno">
			</div>
			
			<div class="form-group">
				<label for="inputApellidoMaterno">Apellido Materno:</label> <input name="txtApellidoMat"
					class="form-control" id="inputApellidoMaterno"
					placeholder="Ingrese su apellido materno">
			</div>

			<div class="form-group">
				<label for="inputUsuario">Usuario:</label> <input type="email" name="txtUsuario"
					class="form-control" id="inputUsuario"
					placeholder="Ingrese su correo electrónico">
			</div>

			<div class="form-group">
				<label for="inputPassword">Contraseña</label> <input type="password" name="txtPassword"
					class="form-control" id="inputPassword"
					placeholder="Ingrese su contraseña">
			</div>
			
			<button name="btnAccion" value="registrar" type="submit" class="btn btn-primary">REGISTRARSE</button>
		</form>
		<br>
		<p>
			Si ya tiene cuenta, ingrese <a href="login.jsp">aquí</a>
		</p>

	</div>

</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

</html>