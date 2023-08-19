package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import mantenimiento.GestionCatalogo;
import model.Producto;

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

		default:
			break;
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
		// leer el codigo del producto a buscar
		int idprod = Integer.parseInt(request.getParameter("id"));

		// obtener la informacion del producto, usando la clase gestion
		Producto p = new GestionCatalogo().buscarIDS(idprod);
		
		System.out.println("ID PRO: " + idprod);
		System.out.println("PRODUCTO");
		System.out.println(p);
		
		// enviar el obj de producto como atributo a la pagina
		request.setAttribute("pro", p);
		request.setAttribute("estadoReg", false); // Validacion de registro

		// reenvia a la pagina
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
