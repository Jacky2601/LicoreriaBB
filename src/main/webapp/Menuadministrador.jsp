<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu Administrador</title>
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
    <h1 class="usuarioh1">MENU ADMINISTRADOR</h1>
    <h2 class="texto3">MANTENIMIENTOS</h2>
    
    <div class="botones3">
   	 	<a href="manteDistritos.jsp">
        <button class="view-more-button2">MANTENIMIENTO DE <br>DISTRITOS DELIVERY</button>
    	</a>
	</div>
	<div class="botones3">
	<a href="manteProductos.jsp">
        <button class="view-more-button2">MANTENIMIENTO DE <br>PRODUCTOS</button>
    	</a>
    </div>
    <div class="botones3">
	<a href="manteUsuarios.jsp">
        <button class="view-more-button2">MANTENIMIENTO DE <br>USUARIOS</button>
    	</a>
    </div>
    
    <h2 class="texto3">CONSULTAS Y REPORTES</h2>
    
    <div class="botones3">
	<a href="reportProductos.jsp">
        <button class="view-more-button2">REPORTE DE PRODUCTOS</button>
    	</a>
    </div>
    <div class="botones3">
	<a href="reportPedidos.jsp">
        <button class="view-more-button2">REPORTE DE PEDIDOS</button>
    	</a>
    </div>
    
    <br>
    <br>
    
    
   	 	<div class="botones3">
   	 	<a href="Index.jsp">
        <button class="view-more-button">SALIR</button>
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