package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import mantenimiento.GestionProducto;
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
		System.out.println("Entro al Servlet de Carta");

		String accion = request.getParameter("btnAccion");
		System.out.println("Opcion seleccionada en el boton: " + accion);

		switch (accion) {
		
		case "listado":
			listarProducto(request, response);
			break;
		
		case "buscarPorId":
			buscarPorIds(request, response);
			break;

		default:
			break;
		}
	}

	private void buscarPorIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Ingreso al proceso buscar por id");
		// leer el codigo del producto a buscar
		int idprod = Integer.parseInt(request.getParameter("id"));

		// obtener la informacion del producto, usando la clase gestion
		//Producto p = new GestionProducto().buscarProductoPorId(idprod);
		
		System.out.println("ID PRO: " + idprod);
		System.out.println("PRODUCTO");
		//System.out.println(p);
		
		// enviar el obj de producto como atributo a la pagina
		//request.setAttribute("pro", p);
		request.setAttribute("estadoReg", false); // Validacion de registro

		// reenvia a la pagina
		request.getRequestDispatcher("DetalleProducto.jsp").forward(request, response);
		
	}

	private void listarProducto(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("Ingreso al proceso catalogo");
		
		GestionProducto gp = new GestionProducto();
		///ArrayList<Producto> listarProducto = gp.listarProducto(); 

		// enviar el listado al jsp --> atributo
		//request.setAttribute("listarProducto", listarProducto);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("productos.jsp").forward(request, response);
		
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
