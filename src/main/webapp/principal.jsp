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
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

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
			
			
			<p>Ud se ha identificado como : <strong> ${u.getNombre() } ${u.apellidoPat } ${u.apellidoMat } ${u.tipo }</strong></p>
		</header>
			
		<main>
			<nav style="width: 25%;float: left;">
				<ul>
					<%-- <li><a href="Actualiza-datos.jsp">Actualizar Datos</a></li>
					<li><a href="crudProductos.jsp">Mantenimiento de Productos</a></li>
					<li><a href="crudProd?btnAccion=cat">Lista de Productos</a></li>
					<li><a href="#">Cerrar sesión</a></li>	--%>
					
					<tools:menuPrincipal tipo = "${u.tipo}"/> 
								
				</ul>
			</nav>
			<section style="width: 65%;float: left;">
				<h1>Bienvenidos</h1>
			</section>
		</main>
		<footer>
		</footer>
	</div>
	
</body>
</html>