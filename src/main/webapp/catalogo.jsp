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
            <li><a href="catalogo?btnAccion=listarVino" class="categoriacat" id="Vino1">Vino</a></li>
            <li><a href="catalogo?btnAccion=listarWhisky" class="categoriacat" id="Whisky1">Whisky</a></li>
            <li><a href="catalogo?btnAccion=listarTequila" class="categoriacat" id="Tequila1">Tequila</a></li>
            <li><a href="catalogo?btnAccion=listarRon" class="categoriacat" id="Ron1">Ron</a></li>
            <li><a href="catalogo?btnAccion=listarChampange" class="categoriacat" id="Champange1">Champange</a></li>
            <li><a href="catalogo?btnAccion=listarVodka" class="categoriacat" id="Vodka1">Vodka</a></li>
            <li><a href="catalogo?btnAccion=listarGin" class="categoriacat" id="Gin1">Gin</a></li>
            <li><a href="catalogo?btnAccion=listarPisco" class="categoriacat" id="Pisco1">Pisco</a></li>
            <li><a href="catalogo?btnAccion=listarOtros" class="categoriacat" id="Otros1">Otros licores</a></li>
        </ul>
    </nav>
    
    <section class="section-Vino" id="Vino">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarVino = (ArrayList<Producto>) request.getAttribute("listarVino");
			if (listarVino != null) {
				for (Producto p : listarVino) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago1" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Vino">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
	
	<section class="section-Whisky" id="Whisky">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarWhisky = (ArrayList<Producto>) request.getAttribute("listarWhisky");
			if (listarWhisky != null) {
				for (Producto p : listarWhisky) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago2" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Whisky">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Tequila" id="Tequila">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarTequila = (ArrayList<Producto>) request.getAttribute("listarTequila");
			if (listarTequila != null) {
				for (Producto p : listarTequila) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago3" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Tequila">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Ron" id="Ron">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarRon = (ArrayList<Producto>) request.getAttribute("listarRon");
			if (listarRon != null) {
				for (Producto p : listarRon) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago4" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Ron">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Champange" id="Champange">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarChampange = (ArrayList<Producto>) request.getAttribute("listarChampange");
			if (listarChampange != null) {
				for (Producto p : listarChampange) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago5" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Champange">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Vodka" id="Vodka">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarVodka = (ArrayList<Producto>) request.getAttribute("listarVodka");
			if (listarVodka != null) {
				for (Producto p : listarVodka) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago6" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Vodka">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Gin" id="Gin">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarGin = (ArrayList<Producto>) request.getAttribute("listarGin");
			if (listarGin != null) {
				for (Producto p : listarGin) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago7" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Gin">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Pisco" id="Pisco">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarPisco = (ArrayList<Producto>) request.getAttribute("listarPisco");
			if (listarPisco != null) {
				for (Producto p : listarPisco) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago8" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Pisco">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
	</div>
	
	
	</section>
    
    <section class="section-Otros" id="Otros">
    <!-- EMPIEZA EL CUADRO DEL PRODUCTO -->
	<div class="filatragos">
	<%
    ArrayList<Producto> listarOtros = (ArrayList<Producto>) request.getAttribute("listarOtros");
			if (listarOtros != null) {
				for (Producto p : listarOtros) { 
	%>
    <!-- DENTRO DEL DIV Y SIGUE EL DIV DE CONTENIDO -->
    <div class="divtraguito">
    
        <img class="imgtrago" id="trago9" src="productos/PRO<%=p.getId_producto()%>.jpg" alt="Otros">
        
        <h2 class="categoria"><%=p.getCategoria()%></h2>
        <h2 class="marca"><%=p.getMarca_prod()%></h2>
        <p class="descripcion"><%=p.getDescripcion()%></p>
        <p class="stock">Stock: <%=p.getStock()%> Unidades</p>
        <h3 class="precio" id="precio">S/. <span id="precio1"><%= String.format("%.2f", p.getPrecio()) %></span></h3>
        
        <div class="buttonslicor">
        	<a href="catalogo?btnAccion=buscarIDS&id=<%=p.getId_producto()%>">
        	<button class="buy-buttonlicor">COMPRAR</button>
        	</a>
    	</div>
    	
        <br>
        
    </div>
    <%
	}
	}
	%>
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
