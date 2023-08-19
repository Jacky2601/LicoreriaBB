<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="mantenimiento.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle Producto</title>
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
            <a href="carrito.jsp">
                <img class="cart-icon" id="r5" src="imagenes/CAR2.png" alt="Carrito de Compras">
            </a>
        </div>
</header>
    
    <section class="products-section">

		<!-- Aquí irá la sección de productos -->
		<div class="cuadros3carta">
		<%
    	ArrayList<Producto> buscarIDS = (ArrayList<Producto>) request.getAttribute("buscarIDS");
			if (buscarIDS != null) {
				for (Producto p : buscarIDS) { 
		%>
			<br>
			<!-- Ejemplo de un producto -->
			<div class="cuadrocarta3">

				<img class="imagenproducto3" id="traguito3"
					src="productos/PRO<%=p.getId_producto()%>.jpg" alt="producto">
				<div class="cuadrito3">
					<h2 class="nombre3"><%=p.getCategoria()%></h2>
					<h2 class="nombre3"><%=p.getMarca_prod()%></h2>
					<p class="descripcion3"><%=p.getDescripcion()%></p>
					<p class="stock">Stock: <%=p.getStock()%> Unidades</p>
					<br>
					<h3 class="precio3" id="precio1">
						S/. <span id="precio"><%= String.format("%.2f", p.getPrecio()) %></span>
					</h3>
					<br>

					<form action="pedido" method="post">
						<div>
							<p>Cantidad:</p>
							<button class="buttons3" id="decrement" type="button">-</button>
							<input class="cant3" type="text" id="quantity" value="0"
								name="cantidad">
							<button class="buttons3" id="increment" type="button">+</button>
						</div>
						<p>SubTotal: S/. <span id="subtotal">0</span></p>
						
						
						
						

						<div class="buttons3">
							<button class="buy-button" type="submit" name="accion"
								value="solPedido">SOLICITAR PEDIDO</button>
						</div>
						<br>
					</form>
				</div>
			</div>
			 <%
	}
	}
	%>
			<!-- Se modifica de acuerdo al producto selecionado -->
		</div>

	</section>

	<div class="regreso2" style="margin-top: 8rem;">
		<a href="catalogo?btnAccion=listarVino">
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
