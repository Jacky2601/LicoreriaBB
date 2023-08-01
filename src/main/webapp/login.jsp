<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Licoreria Big Bang</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">

<link rel="stylesheet" href="css/mis_estilos.css">

<style type="text/css"></style>

</head>
<body>

	<div id="login">
		<h1>Ingresar Usuario</h1>

		<!-- Formulario -->
		<form action="crudUsu" method="post">
			<div class="form-group">
				<label for="inputUsuario">Usuario</label> <input type="email"
					name="txtUsuario" class="form-control" id="inputUsuario"
					placeholder="Ingrese su correo" value="">
			</div>
			<div class="form-group">
				<label for="inputPassword">Contraseña</label> <input type="password"
					name="txtPassword" class="form-control" id="inputPassword"
					placeholder="Ingrese su contraseña" maxlength="8"
					pattern="[a-zA-ZáéíóúÁÉÍÓÚ0-9]{8}" value="">
				<!-- Usamos maxlength y pattern son para controlar la cantidad y las condiciones respectivamente para la contraseña -->
			</div>

			<button name="btnAccion" value="login" type="submit"
				class="btn btn-primary">INGRESAR</button>
		</form>
		<br>
		
		<p>
			Para registrar su cuenta, pulse <a href="registro.jsp">aquí</a>
		</p>
		
		<!-- Muestra el atributo (variable) enviado desde el servlet -->
		${mensaje}

	</div>

</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

</html>