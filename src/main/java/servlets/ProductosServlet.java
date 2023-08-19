package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionProducto;
import model.Producto;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ProductosServlet
 */

@WebServlet(name = "crudProductos", description = "Controlador para el mantenimiento de los Productos", urlPatterns = {
"/crudProductos" })

public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet de Productos");

		String accion = request.getParameter("btnAccion");
		System.out.println("Opcion seleccionada en el boton: " + accion);

		switch (accion) {
		case "registrar":
			registrar(request, response);
			break;
		case "actualizar":
			actualizar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;
		case "listado":
			listar(request, response);
			break;
		case "q":
			buscar(request, response);
			break;
		
		default:
			break;
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ingreso al proceso registrar");

		int id_producto = Integer.parseInt(request.getParameter("txtCodigo"));
		int id_categoria = Integer.parseInt(request.getParameter("cboCategoria"));
		String marca_prod = request.getParameter("txtMarca");
		String descripcion = request.getParameter("txtDescripcion");
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));
			
		Producto p = new Producto(id_producto, id_categoria, marca_prod, descripcion, precio, stock, estado);

		GestionProducto gp = new GestionProducto();
		int ok = gp.registrar(p);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al registrar!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Producto registrado</div>");

		}
		request.getRequestDispatcher("manteProductos.jsp").forward(request, response);
		
		System.out.println(id_producto + " " + id_categoria + " " + marca_prod + " " + descripcion + " " + precio + " " + stock + " " + estado);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso actualizar");

		int id_producto = Integer.parseInt(request.getParameter("txtCodigo"));
		int id_categoria = Integer.parseInt(request.getParameter("cboCategoria"));
		String marca_prod = request.getParameter("txtMarca");
		String descripcion = request.getParameter("txtDescripcion");
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));
		
		Producto p = new Producto(id_producto, id_categoria, marca_prod, descripcion, precio, stock, estado);

		GestionProducto gp = new GestionProducto();
		int ok = gp.actualizar(p);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al actualizar el producto!!!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Producto actualizado</div>");

		}
		request.getRequestDispatcher("manteProductos.jsp").forward(request, response);

		System.out.println(id_producto + " " + id_categoria + " " + marca_prod + " " + descripcion + " " + precio + " " + stock + " " + estado);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso eliminar");

		int id_producto = Integer.parseInt(request.getParameter("txtCodigo"));

		System.out.println(id_producto);

		GestionProducto gp = new GestionProducto();
		int ok = gp.eliminar(id_producto);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al eliminar!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Producto eliminado</div>");

		}
		request.getRequestDispatcher("manteProductos.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso listar");
		
		GestionProducto gp = new GestionProducto();
		ArrayList<Producto> listado = gp.listado(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listado", listado);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("manteProductos.jsp").forward(request, response);

		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso buscar");
		// leer el codigo del producto a buscar
		int id_producto = Integer.parseInt(request.getParameter("id_producto"));

		// obtener la informacion del producto, usando la clase gestion
		Producto p = new GestionProducto().buscar(id_producto);
		

		// enviar el obj de producto como atributo a la pagina
		request.setAttribute("p", p);

		// reenvia a la pagina
		request.getRequestDispatcher("manteProductos.jsp").forward(request, response);
		
	}
	
	private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al proceso buscar por id");
		// leer el codigo del producto a buscar
		int id_producto = Integer.parseInt(request.getParameter("id_producto"));

		// obtener la informacion del producto, usando la clase gestion
		Producto p = new GestionProducto().buscar(id_producto);
		
		System.out.println("ID PRO: " + id_producto);
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
