<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sobre Nosotros</title>
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
    <h1 class="usuarioh1">SOBRE NOSOTROS</h1>
    <h2 class="texto2">Misión</h2>
    <p class="parrafo1">Nuestra misión en "Licorería BIG BANG" es ofrecer a nuestros 
    clientes una experiencia única en el mundo de las bebidas 
    alcohólicas, proporcionando una amplia selección de productos 
    de la más alta calidad. Nos comprometemos a brindar un servicio 
    personalizado y cercano, satisfaciendo las necesidades y 
    preferencias de nuestros clientes. Buscamos ser reconocidos 
    como líderes en el mercado, destacando por nuestra excelencia 
    en el servicio al cliente y la diversidad de nuestras propuestas, 
    siempre con responsabilidad y respeto hacia el consumo 
    responsable.
    </p>
    
    <h2 class="texto2">Visión</h2>
    <p class="parrafo1">En "Licorería BIG BANG" aspiramos a convertirnos en la licorería 
    de preferencia para nuestros clientes, superando sus expectativas y 
    sorprendiéndolos con nuestro catálogo de bebidas y promociones exclusivas. 
    Buscamos ser reconocidos por nuestra innovación, calidad y pasión por el 
    mundo de las bebidas, ofreciendo una experiencia de compra en línea inigualable. 
    Nuestra visión es ser líderes en el mercado digital, contribuyendo al crecimiento 
    y desarrollo del sector de licorerías en línea, siempre guiados por nuestros 
    valores de integridad, responsabilidad y compromiso con la satisfacción del cliente.
    </p>
    
    
   	 	<div class="regreso2">
   	 	<a href="Index.jsp">
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