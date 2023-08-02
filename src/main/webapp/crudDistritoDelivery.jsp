
<%@page import="model.DistritoDelivery"%>
<%@page import="mantenimiento.GestionDistritoDelivery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<header>
			<h1>Cabecera</h1>

			<%--
				Usuario u = (Usuario)request.getAttribute("u");
				if (u==null)
					u = new Usuario();
			
			--%>


			<p>
				Ud se ha identificado como : <strong>${u.getNombre()}
					${u.apellidoPat} ${u.apellidoMat }</strong>
			</p>
		</header>

		<main>

			<section style="width: 65%; float: left;">

				<h1>Mantenimiento de Distritos de Delivery</h1>

				<!-- Formulario -->
				<form action="crudDistritoDelivery" method="post">
					<div class="form-group">
						<label for="inputCodigo">Código del Distrito:</label> <input
							name="txtCodigo" value="${d.idDistrito}" class="form-control"
							id="inputCodigo" placeholder="Ingrese Código del Distrito">
					</div>

					<div class="form-group">
						<label for="inputDescripcion">Nombre del Distrito:</label> <input
							name="txtNombre" value="${d.nombreDistrito }"
							class="form-control" id="inputNombreDistrito"
							placeholder="Ingrese nombre del distrito">
					</div>


					<div class="form-group">
						<label for="inputEstado">Estado:</label> <select name="cboEstado"
							class="form-control" id="exampleFormControlSelect1">
							<option value='-1'>Seleccione</option>
							<option value='1'>Activo</option>
							<option value='2'>Eliminado</option>
						</select>
					</div>


					<br>

					<button type="submit" name="btnAccion" value="registrar"
						class="btn btn-primary">Registrar</button>
					<button type="submit" name="btnAccion" value="actualizar"
						class="btn btn-primary">Actualizar</button>
					<button type="submit" name="btnAccion" value="eliminar"
						class="btn btn-danger">Eliminar</button>
					<button type="submit" name="btnAccion" value="listado"
						class="btn btn-warning">Listado</button>

				</form>
				<br> ${mensaje }
			</section>

			<tr>



				<table class="table">

					<tr>
						<th>Código del Distrito</th>
						<th>Nombre del Distrito</th>
						<th>Estado</th>
					</tr>

					<%
					GestionDistritoDelivery gd = new GestionDistritoDelivery();
					ArrayList<DistritoDelivery> listado = gd.listado();

					if (listado != null) {
						for (DistritoDelivery d : listado) {
					%>
					<tr>
						<td><%=d.getIdDistrito()%></td>
						<td><%=d.getNombreDistrito()%></td>
						<td><%=d.getEstado()%></td>
					</tr>
					<%
					}
					}
					%>

				</table>
			</main>

		<footer> </footer>
	</div>
	<div id="login"></div>


</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

</html>