<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Reporte Pedidos</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/mis_estilos.css">
</head>
<body>
<header class="header">
        <div class="logo-container">
        	<a href="Index.jsp">
            <img  class="logo" src="imagenes/LOGOLICO.jpeg"  alt=" ">
            </a>
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
            <a href="carritoCompras.jsp">
                <img class="cart-icon" id="r5" src="imagenes/CAR2.png" alt="Carrito de Compras">
            </a>
        </div>
</header>
	
	<div class="reporte" id="reporte">
		<div class="partereporte">
			<h2 >REPORTE DE PEDIDOS</h2>
			
			<form action="pedido" method="post">

				<div class="fechas">
					<label for="desde">DESDE:</label> 
					<input type="date" id="desde" name="desde"> 
					<label for="hasta">HASTA:</label> 
					<input type="date" id="hasta" name="hasta">
				</div>
				<div class="botonesrep">

					<button class="botonesreporte" id="consultar" type="submit" name="accion"
							value="reporte">CONSULTAR</button>
					<button class="botonesreporte" id="imprime" type="submit" name="accion"
							value="reporte">IMPRIMIR PDF</button>
				</div>
			</form>

			<div class="container mt-3">

				<table class="table table-hover">
					<thead>
						<tr>
							<th style="width: 5%; text-align: center;">Código</th>
							<th style="width: 15%; text-align: left;">Cliente</th>
							<th style="width: 15%; text-align: left;">Direccion Cliente</th>
							<th style="width: 15%; text-align: left;">Nombre Producto</th>
							<th style="width: 5%; text-align: center;">Cantidad</th>
							<th style="width: 5%; text-align: right;">Precio</th>
							<th style="width: 10%; text-align: right;">Subtotal</th>
							<th style="width: 10%; text-align: center;">Estado</th>
						</tr>
					</thead>
					<tbody>
						<%--
						ArrayList<Pedido> listado = (ArrayList<Pedido>) request.getAttribute("listado");

						if (listado != null) {
							for (Pedido p : listado) {
						--%>
						<%--
						<tr>
							<td style="text-align: center;"><%=p.getIdPed()%></td>
							<td><%=p.getNombreCliente()%></td>
							<td><%=p.getDireccionCliente()%></td>
							<td><%=p.getNombreProducto()%></td>
							<td style="text-align: center;"><%=p.getCantidad()%></td>
							<td style="text-align: right;"><%=p.getPrecio()%></td>
							<td style="text-align: right;"><%=p.getSubtotal()%></td>
							<td style="text-align: center;"><%=p.getEstadoPedido()%></td>
						</tr>
						<%
						}
						}
						--%>
					</tbody>
				</table>
			</div>

			<!--table-->
			<!-- Tu tabla de reporte aquí -->
			<!--/table-->
		</div>
	</div>


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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>