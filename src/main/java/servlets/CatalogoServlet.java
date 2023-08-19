package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import mantenimiento.GestionCatalogo;
import model.*;

@WebServlet(name = "catalogo", 
description = "Controlador para listar catalogo de productos", 
urlPatterns = {"/catalogo" })
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet de Catalogo");

		String accion = request.getParameter("btnAccion");
		System.out.println("Opcion seleccionada en el boton: " + accion);

		switch (accion) {
		
		case "listarVino":
			listarVino(request, response);
			break;
			
		case "listarWhisky":
			listarWhisky(request, response);
			break;
			
		case "listarTequila":
			listarTequila(request, response);
			break;
			
		case "listarRon":
			listarRon(request, response);
			break;
			
		case "listarChampange":
			listarChampange(request, response);
			break;
			
		case "listarVodka":
			listarVodka(request, response);
			break;
			
		case "listarGin":
			listarGin(request, response);
			break;
			
		case "listarPisco":
			listarPisco(request, response);
			break;
			
		case "listarOtros":
			listarOtros(request, response);
			break;
		
		case "buscarIDS":
			buscarIDS(request, response);
			break;

		case "añadirProductos":
			añadirProductos(request, response);
			break;
			
		case "eliminarProducto":
            eliminarProductoDelCarrito(request , response);
            break;

		default:
			break;
		}
	}

	private void eliminarProductoDelCarrito(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
		// Obtener el ID del producto a eliminar desde el formulario
	    int productoId = Integer.parseInt(request.getParameter("productoId"));

	    // Obtener la lista del carrito desde la sesión
	    ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");

	    // Verificar si el carrito no es null antes de usarlo
	    if (carrito != null) {
	        // Buscar el producto en el carrito y eliminarlo
	        for (int i = 0; i < carrito.size(); i++) {
	            if (carrito.get(i).getProducto().getId_producto() == productoId) {
	                carrito.remove(i);
	                break; // Puedes romper el bucle ya que encontraste el producto
	            }
	        }

	        // Actualizar la sesión con el carrito modificado
	        request.getSession().setAttribute("carrito", carrito);
	    }

	 // Redirigir a la página del carrito
        response.sendRedirect("carritoCompras.jsp");
	    }



	private void añadirProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
		        int idprod = Integer.parseInt(request.getParameter("id"));
		        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		        // Validación de entrada y manejo de excepciones si es necesario

		        GestionCatalogo gp = new GestionCatalogo();
		        Producto producto = gp.buscarIDS(idprod);

		        if (producto != null) {
		            // Recuperar el carrito de compras de la sesión
		            ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");

		            if (carrito == null) {
		                carrito = new ArrayList<>();
		            }

		         // Verificar si el producto ya existe en el carrito
		            boolean productoExistente = false;
		            for (Carrito item : carrito) {
		                if (item.getProducto().getId_producto() == idprod) {
		                    // El producto ya existe en el carrito, actualizar la cantidad
		                    item.setCantidad(item.getCantidad() + cantidad);
		                    productoExistente = true;
		                    break;
		                }
		            }

		            if (!productoExistente) {
		                // Agregar el producto y cantidad al carrito
		                Carrito item = new Carrito();
		                item.setProducto(producto);
		                item.setCantidad(cantidad);
		                carrito.add(item);
		            }

		            // Actualizar el carrito en la sesión
		            request.getSession().setAttribute("carrito", carrito);

		            // Redirigir a la página del carrito
		            response.sendRedirect("carritoCompras.jsp");
		        } else {
		            // Producto no encontrado, mostrar mensaje de error
		            request.setAttribute("mensaje", "El producto no se encontró");
		            request.getRequestDispatcher("error.jsp").forward(request, response);
		        }
		    } catch (NumberFormatException e) {
		        // Manejo de errores de conversión de números
		        request.setAttribute("mensaje", "Error en los parámetros de entrada");
		        request.getRequestDispatcher("error.jsp").forward(request, response);
		    } catch (Exception e) {
		        // Manejo de otras excepciones
		        request.setAttribute("mensaje", "Error interno en la aplicación");
		        request.getRequestDispatcher("error.jsp").forward(request, response);
		    }
	}

	private void listarOtros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Otros");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarOtros = gp.listarOtros(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarOtros", listarOtros);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarPisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Pisco");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarPisco = gp.listarPisco(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarPisco", listarPisco);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarGin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Gin");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarGin = gp.listarGin(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarGin", listarGin);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarVodka(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Vodka");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarVodka = gp.listarVodka(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarVodka", listarVodka);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarChampange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Champange");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarChampange = gp.listarChampange(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarChampange", listarChampange);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarRon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Ron");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarRon = gp.listarRon(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarRon", listarRon);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarTequila(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Tequila");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarTequila = gp.listarTequila(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarTequila", listarTequila);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarWhisky(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Whisky");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarWhisky = gp.listarWhisky(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarWhisky", listarWhisky);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void listarVino(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo Vino");
		
		GestionCatalogo gp = new GestionCatalogo();
		ArrayList<Producto> listarVino = gp.listarVino(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listarVino", listarVino);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}
	
	
	private void buscarIDS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Ingreso al proceso buscar por ID");
	    // Leer el código del producto a buscar
	    int idprod = Integer.parseInt(request.getParameter("id"));

	    // Obtener la información del producto, usando la clase GestionCatalogo
	    GestionCatalogo gp = new GestionCatalogo();
	    Producto p = gp.buscarIDS(idprod);

	    System.out.println("ID PRO: " + idprod);
	    System.out.println("PRODUCTO");
	    System.out.println(p);

	    // Enviar el objeto de producto como atributo a la página
	    request.setAttribute("pro", p);

	    // Reenviar a la página
	    request.getRequestDispatcher("detalleProducto.jsp").forward(request, response);
	}

	

	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
