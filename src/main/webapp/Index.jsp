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
    <nav class="navbar">
        <ul>
            <li><a href="Index.jsp">INICIO</a></li>
            <li><a href="catalogo?btnAccion=listarVino">VINOS</a></li>
            <li><a href="catalogo?btnAccion=listarWhisky">LICORES</a></li>
            <li><a href="nosotros.jsp">NOSOTROS</a></li>
        </ul>
    </nav>
    <section class="panel">
        <img class="panel-image" id="imgcab" src="imagenes/IMG8.jpg" alt="Panel de Imagen">
    </section>
    
        <section class="section-Inicio" id="InicioLic">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	
    
    <div class="divtraguito">
    
        <img class="imgtrago" id="traguis" src="productos/PRO47.jpg" alt="index">
        
        <h2 class="categoria">Whisky</h2>
        <h2 class="marca">JOHNNIE WALKER</h2>
        <p class="descripcion">18 años Botella 750ml</p>
        <p class="stock">Stock: 250 Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1">349.00</span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=47">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    
    <div class="divtraguito">
    
        <img class="imgtrago" id="traguis" src="productos/PRO48.jpg" alt="index">
        
        <h2 class="categoria">Whisky</h2>
        <h2 class="marca">JOHNNIE WALKER</h2>
        <p class="descripcion">Double Black Label Botella 750ml</p>
        <p class="stock">Stock: 300 Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1">149.90</span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=48">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    
    <div class="divtraguito">
    
        <img class="imgtrago" id="traguis" src="productos/PRO49.jpg" alt="index">
        
        <h2 class="categoria">Whisky</h2>
        <h2 class="marca">JOHNNIE WALKER</h2>
        <p class="descripcion">Gold Label Botella 750ml</p>
        <p class="stock">Stock: 280 Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1">204.90</span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=49">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    
    <div class="divtraguito">
    
        <img class="imgtrago" id="traguis" src="productos/PRO46.jpg" alt="index">
        
        <h2 class="categoria">Whisky</h2>
        <h2 class="marca">JOHNNIE WALKER</h2>
        <p class="descripcion">Blue Label Botella 750ml</p>
        <p class="stock">Stock: 150 Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1">959.90</span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=46">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    
    <div class="divtraguito">
    
        <img class="imgtrago" id="traguis" src="productos/PRO53.jpg" alt="index">
        
        <h2 class="categoria">Whisky</h2>
        <h2 class="marca">JACK DANIELS</h2>
        <p class="descripcion">Sinatra Select Botella 1L</p>
        <p class="stock">Stock: 240 Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1">799.90</span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=53">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    
    </div>
	
	
	</section>
        
   
    <section class="product-panel">
    	<a href="catalogo?btnAccion=buscarIDS&id=3">
        <img class="panel-image" src="imagenes/BAN1.jpg" alt="Panel de Imagen">
        </a>
    </section>
    <div class="buttons">
    	<a href="catalogo?btnAccion=buscarIDS&id=3">
        <button class="buy-button">COMPRAR</button></a>
        <a href="catalogo?btnAccion=listarWhisky">
        <button class="view-more-button">VER MÁS</button></a>
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