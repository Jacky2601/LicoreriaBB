<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Licoreria Big Bang</title>
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
            <a href="login.jsp">
            INGRESA O REGÍSTRATE  
                <img class="login-icon" src="imagenes/user.png" alt="Ingresar o Registrarse">
                 
            </a>
        </div>
        <div class="cart-container">
            <a href="carrito.html">
                <img class="cart-icon" id="r5" src="imagenes/CAR2.png" alt="Carrito de Compras">
            </a>
        </div>
    </header>
    <h1 class="usuarioh1">REGISTRAR USUARIO</h1>
	<div id="login">
		<div class="formulariologin">
		<!-- Formulario -->
		<form action="crudUsu" method="post">
			<div class="form-group">
				<label for="inputNombre">Nombre:</label> <input name="txtNombre" class="form-control"
					id="inputNombre" placeholder="Ingrese su Nombre">
			</div>

			<div class="form-group">
				<label for="inputApellidoPaterno">Apellido Paterno:</label> <input name="txtApellidoPat"
					class="form-control" id="inputApellidoPaterno"
					placeholder="Ingrese su apellido paterno">
			</div>
			
			<div class="form-group">
				<label for="inputApellidoMaterno">Apellido Materno:</label> <input name="txtApellidoMat"
					class="form-control" id="inputApellidoMaterno"
					placeholder="Ingrese su apellido materno">
			</div>

			<div class="form-group">
				<label for="inputUsuario">Usuario:</label> <input type="email" name="txtUsuario"
					class="form-control" id="inputUsuario"
					placeholder="Ingrese su correo electrónico">
			</div>

			<div class="form-group">
				<label for="inputPassword">Contraseña</label> <input type="password" name="txtPassword"
					class="form-control" id="inputPassword"
					placeholder="Ingrese su contraseña">
			</div>
			
			<button name="btnAccion" value="registrar" type="submit" class="btn btn-primary">REGISTRARSE</button>
		</form>
		<br>
		<p>
			Si ya tiene cuenta, ingrese <a href="login.jsp">aquí</a>
		</p>

	</div>
	<div class="regreso1">
   	 	<a href="Index.jsp">
        <button class="view-more-button">REGRESAR</button>
    	</a>
		</div>
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
