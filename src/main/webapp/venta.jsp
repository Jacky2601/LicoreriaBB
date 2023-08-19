<%@page import="model.Producto"%>
<%@page import="model.DistritoDelivery"%>
<%@page import="model.DetalleVenta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pedido</title>
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
    
     <div class="pedido-container">
        <div class="pedido-header">
            <h1 class="pedido-title">Realizar Venta</h1>
        </div>
        <%
            ArrayList<Producto> listaProducto = (ArrayList<Producto>) request.getAttribute("producto");
            ArrayList<DistritoDelivery> listaDistrito = (ArrayList<DistritoDelivery>) request.getAttribute("distrito");
            ArrayList<DetalleVenta> listaDetalleVenta = (ArrayList<DetalleVenta>) request.getAttribute("listaDetalles");
        %>
        
         <form action="venta" method="post">
        <!-- Campos para registrar una nueva venta -->
        <label for="fechaVenta">Fecha de Venta:</label>
        <input type="date" name="fechaVenta" required><br>
        
        <!-- Otros campos para la información del cliente, distrito, etc. -->
        <div class="form-column">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" placeholder="Nombre">
                <label for="apellido">Apellido:</label>
                <input type="text" id="apellido" name="apellido" placeholder="Apellido">
                <label for="nombre">Celular:</label>
                <input type="text" id="celular" name="celular" placeholder="Celular">
                <label for="apellido">DNI:</label>
                <input type="text" id="dni" name="dni" placeholder="DNI">
                <label for="apellido">Dirección:</label>
                <input type="text" id="direccion" name="direccion" placeholder="Direccion">
                <label for="nombre">Observaciones:</label>
                <input type="text" id="observaciones" name="observaciones" placeholder="Observaciones">
            </div>
         
               
        <div class="col-md-4">
            <div class="mt-4">
            <button type="submit" name="accion" value="agregar" class="btn btn-primary">Agregar</button>
         	</div>
         </div>
            	
    </form>
    
    <hr>
    
    <h2>Detalles de Venta</h2>
    
    <form action="venta" method="post">
    
    <div class="row">
            	<div class="col-md-4">
            		<div class="form-group">
                		<label for="producto">Producto:</label> 
                		<select name="producto" id="productoId" class="form-control">

							<%-- <%
							for(Producto obj : listaProducto) {
							%><option value="<%=obj.getId_producto()%>"><%=obj.getMarca_prod()%></option>
							<%
							}
							%> --%>

							<%
							try {
							    for(Producto obj : listaProducto) {
							%>
							<option value="<%=obj.getId_producto()%>"><%=obj.getMarca_prod()%></option>
							<%
							}
							} catch (Exception e) {
							e.printStackTrace();
							}
							%>

						</select>
           	 		</div>
           	 	</div>
           	 	
           	 	
           		<div class="col-md-4">
            		<div class="form-group">
                		<label for="cantidad">Cantidad:</label>
                		<input type="number" name="cantidad" required id="cantidadId" class="form-control">
            		</div>
            	</div>
            
            	
            </div>
         
          <hr>
    
    <h2>Lista de Detalles de Venta</h2>
    
    <table>
        <tr>
            <th>Producto</th>
            <th>Cantidad</th>
            
            <!-- Otros encabezados -->
        </tr>
        
        <!-- Iterar sobre la lista de detalles de venta y mostrarlos en filas -->
        <%
            for (DetalleVenta detalle : listaDetalleVenta) {
        %>
            <tr>
                <td><%= detalle.getId_producto() %></td>
                <td><%= detalle.getCantidad() %></td>
                <!-- Otros campos -->
            </tr>
        <%
            }
        %>
   
   
    
    <div class="metodo-pago">
            <p>Método de pago:</p>
            <label><input type="radio" name="metodoPago" value="POS">POS</label>
            <label><input type="radio" name="metodoPago" value="EFECTIVO">EFECTIVO</label>
        </div>

        <div class="metodo-entrega">
            <p>Método de entrega:</p>
            <label><input type="radio" name="metodoEntrega" value="DELIVERY">Delivery</label>
            <label><input type="radio" name="metodoEntrega" value="RETIRO">Retiro en Tienda</label>
        </div>
        
        
        
         <div class="resumen-total">
            <p>Subtotal: S/. <span id="subtotal">0</span></p>
            <p>Delivery:  <span id="delivery">gratis</span></p>
            <p>Total: S/. <span id="total">0</span></p>
        </div>
        
        
         </div>
        <div class="pedido-buttons">
        	<a href="Pedido.jsp">
            <button class="pedido-button">REALIZAR PEDIDO</button>
            </a>
            <a href="CanastaCompras.jsp">
            <button class="pedido-button">REGRESAR ATRÁS</button>
            </a>
            <a href="Index.jsp">
            <button class="pedido-button">CANCELAR</button>
            </a>
        </div>
      
      
    </div>
            
    </form>
    
     
    </table>
    
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