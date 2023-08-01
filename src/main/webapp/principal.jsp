

<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
// validar si ha logueado
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Licoreria Big Bang</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Agrega el enlace al archivo JavaScript de jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
				Ud se ha identificado como : <strong> ${u.getNombre() }
					${u.apellidoPat } ${u.apellidoMat } ${u.tipo }</strong>
			</p>
		</header>

		<main>
			<nav style="width: 25%; float: left;">
				<ul>
					<%-- <li><a href="Actualiza-datos.jsp">Actualizar Datos</a></li>
					<li><a href="crudProductos.jsp">Mantenimiento de Productos</a></li>
					<li><a href="crudProd?btnAccion=cat">Lista de Productos</a></li>
					<li><a href="#">Cerrar sesión</a></li>	--%>

					<tools:menuPrincipal tipo="${u.tipo}" />

				</ul>
			</nav>
			<section style="width: 65%; float: left;">
				<h1>Bienvenidos</h1>
			</section>
		</main>

		<!-- Código para la ventana emergente -->
		<div class="modal fade" id="registroExitosoModal" tabindex="-1"
			role="dialog" aria-labelledby="registroExitosoModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="registroExitosoModalLabel">Registro
							exitoso</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Cerrar">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">¡Registro exitoso! El registro se ha
						realizado correctamente.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Código para mostrar la ventana emergente -->
		<script>
			// Llamar a la función para mostrar la ventana emergente cuando se cargue la página
			$(document)
					.ready(
							function() {
		<%-- Verificar si el atributo "registroExitoso" está presente en la sesión --%>
			
		<%if (request.getSession().getAttribute("registroExitoso") != null
		&& (boolean) request.getSession().getAttribute("registroExitoso")) {%>
			$('#registroExitosoModal').modal('show');
		<%-- Eliminar el atributo "registroExitoso" de la sesión después de mostrar la ventana emergente --%>
			
		<%request.getSession().removeAttribute("registroExitoso");%>
			
		<%}%>
			});
		</script>

		<li class="nav-item active"><a class="nav-link"
			href="crudUsu?btnAccion=logout">Cerrar Sesión <span
				class="sr-only">(current)</span>
		</a></li>

		<footer> </footer>
	</div>

</body>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	
</html>