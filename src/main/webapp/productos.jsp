<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="mantenimiento.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
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
    <nav class="barraProducto">
        <ul>
            <li><a href="#" onclick="mostrarSeccion('Vino')" class="categoriacat" id="Vino1">Vino</a></li>
            <li><a href="#" onclick="mostrarSeccion('Whisky')" class="categoriacat" id="Whisky1">Whisky</a></li>
            <li><a href="#" onclick="mostrarSeccion('Tequila')" class="categoriacat" id="Tequila1">Tequila</a></li>
            <li><a href="#" onclick="mostrarSeccion('Ron')" class="categoriacat" id="Ron1">Ron</a></li>
            <li><a href="#" onclick="mostrarSeccion('Champange')" class="categoriacat" id="Champange1">Champange</a></li>
            <li><a href="#" onclick="mostrarSeccion('Vodka')" class="categoriacat" id="Vodka1">Vodka</a></li>
            <li><a href="#" onclick="mostrarSeccion('Gin')" class="categoriacat" id="Gin1">Gin</a></li>
            <li><a href="#" onclick="mostrarSeccion('Pisco')" class="categoriacat" id="Pisco1">Pisco</a></li>
            <li><a href="#" onclick="mostrarSeccion('Otros')" class="categoriacat" id="Otros1">Otros licores</a></li>
        </ul>
    </nav>
    
    <section class="section-Vino" id="Vino">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
        <img class="imgtrago" id="trago1" src="productos/PRO1.jpg" alt="Vino">
        <h2 class="categoria">Vino</h2>
        <h2 class="marca">EL ENEMIGO</h2>
        <p class="descripcion">Cabernet Franc Botella 750ml</p>
        
        <h3 class="precio" id="precio">S/.<span id="precio1">86.90</span></h3>
        <div class="buttons">
        	<a href="DetalleProducto.jsp">
        	<button class="buy-button">COMPRAR</button>
        	</a>
    	</div>
        <br>
    </div>
    
	</div>
	
	
	</section>
    
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
