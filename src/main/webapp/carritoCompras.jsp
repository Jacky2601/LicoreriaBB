<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="mantenimiento.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Carrito Compras</title>
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
   
    <section class="products-carrito">
        <div class="cuadros4canasta">
            <% 
            ArrayList<Carrito> carrito = (ArrayList<Carrito>) session.getAttribute("carrito");
            double importeTotal = 0;

            if (carrito != null && !carrito.isEmpty()) {
                for (int i = 0; i < carrito.size(); i++) {
                    Carrito item = carrito.get(i);
                    Producto producto = item.getProducto();
                    int cantidad = item.getCantidad();
                    double importe = producto.getPrecio() * cantidad;
                    importeTotal += importe;
            %>
            <!-- Ejemplo de un producto en el carrito -->
            <div class="cuadrocanasta4">
                <h2><%= i + 1 %></h2>
                <!-- Aquí puedes mostrar la imagen y detalles del producto -->
                <img class="imagenproducto4" id="pollo15" src="productos/PRO<%=producto.getId_producto()%>.jpg" alt="producto">
                <div class="cuadrito4">
                	
                    <h2 class="nombre4"><%= producto.getCategoria() %> <%= producto.getMarca_prod() %></h2>
                    <h3 class="precio4" id="precio1">S/. <span id="precio"><%= String.format("%.2f", producto.getPrecio()) %></span></h3>
                    
                    <div class="bloque4">
                        <p>Cantidad:</p>
                        <div class="bloque41">
                            <!-- Aquí muestra la cantidad y botones de incremento/decremento -->
                           
                            <input class="cant4" type="text" id="quantity" value="<%= cantidad %>" readonly>
                            
                        </div>
                    </div>
                    <p>Importe: S/. <span id="subtotal"><%= String.format("%.2f", importe) %></span></p>
                    <div>
                        <form action="catalogo" method="post">
                            <input type="hidden" name="btnAccion" value="eliminarProducto">
                            <input type="hidden" name="productoId" value="<%= producto.getId_producto() %>">
                            <button type="submit" class="buy-button4">ELIMINAR</button>
                        </form>
                    </div>
                    <br>
                </div>
            </div>
            <!-- Fin del ejemplo de producto en el carrito -->
            <%
                }
            } else {
            %>
            <!-- Mostrar mensaje si el carrito está vacío -->
            <div class="mensaje-carrito-vacio">
                <p>El carrito de compras está vacío.</p>
            </div>
            <%
            }
            %>
        </div>
    </section>
	
   
   
  <section class="totalesgg">
  <hr class="linea14">
    <div class="totalcanasta">
        <p>SubTotal: S/. <span id="subtotal2"><%= String.format("%.2f",importeTotal) %></span></p>
    </div>
   
   
    <div class="buttonscana">
    	<a href="Pedido.jsp">
        <button class="view-more-button14">REALIZAR PEDIDO</button>
        </a>
        <a href="catalogo?btnAccion=listarVino">
        <button class="view-more-button14">SEGUIR COMPRANDO</button>
        </a>
    </div>
    
    <div class="regreso2">
   	 	<a href="Index.jsp">
        <button class="view-more-button">REGRESAR</button>
    	</a>
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
