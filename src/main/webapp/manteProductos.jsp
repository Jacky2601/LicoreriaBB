<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="mantenimiento.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Mantenimiento Productos</title>
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
	<h2>MANTENIMIENTO DE PRODUCTOS</h2>
		<div class="partemantenimiento">
		<main class="container1">
			<div class="partecontainer1">
			<section class="container1">

				
				<!-- Formulario -->
				<form action="crudProductos" method="post">
						<div class="form-group">
							<label for="inputCodigo">Código del Producto:</label> <input
								name="txtCodigo" value="${p.id_producto }" class="form-control"
								id="inputCodigo" placeholder="Ingrese Código">
						</div>
						
						<div class="form-group">
							<label for="inputCategoria">Categoría:</label> <select
								name="cboCategoria" class="form-control"
								id="exampleFormControlSelect1">
								<option value='-1'>Seleccione</option>
								<option value='1'>Vino</option>
								<option value='2'>Whisky</option>
								<option value='3'>Tequila</option>
								<option value='4'>Ron</option>
								<option value='5'>Champange</option>
								<option value='6'>Vodka</option>
								<option value='7'>Gin</option>
								<option value='8'>Pisco</option>
								<option value='9'>Otros licores</option>
							</select>
						</div>
						

						<div class="form-group">
							<label for="inputMarcaProd">Marca del Producto:</label> <input
								name="txtMarca" value="${p.marca_prod }" class="form-control"
								id="inputMarcaProd"
								placeholder="Ingrese la marca del producto">
						</div>

						<div class="form-group">
							<label for="inputDescripcion">Descripción:</label> <input
								name="txtDescripcion" value="${p.descripcion }"
								class="form-control" id="inputDescripcion"
								placeholder="Ingrese la descripción del producto">
						</div>
						
						
						<div class="form-group col-md-6">
							<label for="inputPrecio">Precio:</label> <input type="number"
								name="txtPrecio" value="${p.precio }" class="form-control"
								id="inputPrecio" placeholder="0.00" min="0" step="0.01">
						</div>
						
																		
						<div class="form-group col-md-6">
							<label for="inputStock">Stock:</label> <input type="number"
								name="txtStock" value="${p.stock }" class="form-control"
								id="inputStock" placeholder="0" min="0">
						</div>
						

						<div class="form-group col-md-6">
							<label for="inputEstado">Estado:</label> <select name="cboEstado"
								class="form-control" id="exampleFormControlSelect1">
								<option value='-1'>Seleccione</option>
								<option value='1'>Activo</option>
								<option value='2'>Eliminado</option>
							</select>
						</div>

						<br>

						<button type="submit" name="btnAccion" value="registrar"
							class="btn btn-primary">Registrar</button>
						<button type="submit" name="btnAccion" value="actualizar"
							class="btn btn-primary">Actualizar</button>
						<button type="submit" name="btnAccion" value="eliminar"
							class="btn btn-danger">Eliminar</button>
						<button type="submit" name="btnAccion" value="listado"
							class="btn btn-warning">Listado</button>

					</form>
				
					<br> ${mensaje }
			</section></div>
			
				<div class= "container2">
				<table class="table">

					<tr>
						<th>Código del Producto</th>
						<th>Categoria</th>
						<th>Marca del Producto</th>
						<th>Descripción</th>
						<th>Precio</th>
						<th>Stock</th>	
					</tr>

					<%
					GestionProducto gp = new GestionProducto();
					ArrayList<Producto> listado = gp.listado();

					if (listado != null) {
						for (Producto p : listado) {
					%>
					<tr>
						<td><%=p.getId_producto()%></td>
						<td><%=p.getId_categoria()%></td>
						<td><%=p.getMarca_prod()%></td>
						<td><%=p.getDescripcion()%></td>
						<td><%=p.getPrecio()%></td>
						<td><%=p.getStock()%></td>
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