<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Licorería Big Bang</title>
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
    <nav class="navbar">
        <ul>
            <li><a href="Index.jsp">INICIO</a></li>
            <li><a href="Index.jsp">VINOS</a></li>
            <li><a href="Index.jsp">LICORES</a></li>
            <li><a href="nosotros.jsp">NOSOTROS</a></li>
        </ul>
    </nav>
    <section class="panel">
        <img class="panel-image" id="imgcab" src="imagenes/IMG8.jpg" alt="Panel de Imagen">
    </section>
    <section class="products-section">
        <!-- Aquí irá la sección de productos -->
        <a href="Index.jsp">
        <img class="panel-image" src="imagenes/produ.jpg" alt="Panel de Imagen">
        </a>
    </section>
    <section class="product-panel">
    	<a href="Index.jsp">
        <img class="panel-image" src="imagenes/BAN1.jpg" alt="Panel de Imagen">
        </a>
    </section>
    <div class="buttons">
        <button class="buy-button">COMPRAR</button>
        <button class="view-more-button">VER MÁS</button>
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
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var userLoggedIn = <%= session.getAttribute("u") != null %>;

        var ingresoLink = document.getElementById("ingreso1");
        var ingresadoDiv = document.getElementById("ingresado1");

        if (userLoggedIn) {
            ingresoLink.style.display = "none";
            ingresadoDiv.style.display = "block";
        } else {
            ingresoLink.style.display = "block";
            ingresadoDiv.style.display = "none";
        }
    });
</script>