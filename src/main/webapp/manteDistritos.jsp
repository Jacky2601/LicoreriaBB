<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.DistritoDelivery"%>
<%@page import="mantenimiento.GestionDistritoDelivery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mantenimiento Distritos</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/mis_estilos.css">
</head>
<body>
<header class="header">
        <div class="logo-container">
        	<a href="Index.jsp">
            <img  class="logo" src="imagenes/LOGOLICO.jpeg"  alt=" ">
            </a>
        </div>
        
        <div class="search-container">
            <input type="text" class="search" placeholder="Buscar Producto">
        </div>
        <div class="locations-container">
            <a href="locales.jsp">
            LOCALES  
                <img class="location-icon" src="imagenes/ubica.png" alt="">
                
            </a>
        </div>
        <div class="login-container">
    	<% if (session.getAttribute("u") != null) { %>
        	<div id="ingresado1">
	            <p> <strong> ${u.getNombre() } ${u.apellidoPat } ${u.apellidoMat }</strong></p>
	            <button class="nav-item active">
	                <a class="nav-link" href="crudUsu?btnAccion=logout"> Cerrar Sesión</a>
	            </button>
	            <span class="sr-only"></span>
        	</div>
    	<% } else { %>
	        <a href="login.jsp" id="ingreso1"> INGRESA O REGÍSTRATE 
	            <img class="login-icon" src="imagenes/user.png" alt="Ingresar o Registrarse">
	        </a>
    	<% } %>
		</div>
        <div class="cart-container">
            <a href="carrito.jsp">
                <img class="cart-icon" id="r5" src="imagenes/CAR2.png" alt="Carrito de Compras">
            </a>
        </div>
</header>
		
	<div class="mantenimiento" id="mantenimiento">
	<h2>MANTENIMIENTO DE DISTRITOS DELIVERY</h2>
		<div class="partemantenimiento">
		<main class="container1">
			<div class="partecontainer1">
			<section class="container1">

				

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
				<div class="botonesmantenimiento">
					<button type="submit" name="btnAccion" value="registrar"
						class="btn btn-primary">Registrar</button>
					<button  type="submit" name="btnAccion" value="actualizar"
						class="btn btn-primary">Actualizar</button>
					<button type="submit" name="btnAccion" value="eliminar"
						class="btn btn-danger">Eliminar</button>
					<button  type="submit" name="btnAccion" value="listado"
						class="btn btn-warning">Listado</button>
				</div>
				</form>
				<br> ${mensaje }
			</section></div>
				<div class= "container2">
				<table class="table">

					<tr>
						<th>Código del Distrito</th>
						<th>Nombre del Distrito</th>
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
					</tr>
					<%
					}
					}
					%>

				</table>
				</div>
				</main>
				</div></div>
				
		<div class="regreso3">
   	 	<a href="Menuadministrador.jsp">
        <button class="view-more-button">REGRESAR</button>
    	</a>
		</div>

 <footer class="footer">
        <div class="disclaimer-bar">
            <p class="disclaimer-text">TOMAR BEBIDAS ALCOHÓLICAS EN EXCESO ES DAÑINO. ESTÁ PROHIBIDA LA VENTA DE ALCOHOL A MENORES DE 18 AÑOS.</p>
        </div>
        <div class="footer-container">
    		<div class="logofooter">
    		<a href="Index.jsp">
        	<img class="logofooter" src="imagenes/LOGOLICO.png" alt=" ">
        	</a>
    	</div>
    	<div class="contact-bar">
        	<p class="contact-text">CONTÁCTANOS</p>
        	<p class="contact-info">Atención Delivery: Lima 12:00 pm. a 10:00 pm.</p>
        	<p class="contact-info">Central Lima: (01) 500 2551</p>
        	<p class="contact-info">Email: atencionalcliente@bigbang.com.pe</p>
    	</div>
		</div>

        <p>
           SÍGUENOS EN<br/></p>
           <div class="redes">
                <a href="https://www.facebook.com/" target="_blank"><img id="r1" src="imagenes/fb.png" alt="" /></a>
                <a href="https://www.instagram.com/" target="_blank"><img id="r2" src="imagenes/ig.png" alt="" /></a>
                <a href="https://www.twitter.com/" target="_blank"><img id="r3" src="imagenes/tw.png" alt="" /></a>
                <a href="https://www.youtube.com/" target="_blank"><img id="r4" src="imagenes/yt.png" alt="" /></a>
            </div>
           <p> 
           © 2023 BigBang.com.pe - Todos los derechos reservados</br>
        </p>
    </footer>
</body>
</html>
<script src="js/carrusel.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

