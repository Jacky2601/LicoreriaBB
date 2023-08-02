package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionDistritoDelivery;
import model.DistritoDelivery;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class DistritoDeliveryServlet
 */

@WebServlet(name = "crudDistritoDelivery", description = "Controlador para el mantenimiento de los Distritos de Delivery", urlPatterns = {
		"/crudDistritoDelivery" })

public class DistritoDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DistritoDeliveryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entro al Servlet de DistritoDelivery");

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

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// leer el codigo del distrito a buscar
		int idDistrito = Integer.parseInt(request.getParameter("txtCodigo"));

		// obtener la informacion del producto, usando la clase getsion
		DistritoDelivery d = new GestionDistritoDelivery().buscar(idDistrito);

		// enviar el obj de distrito como atributo a la pagina
		request.setAttribute("d", d);

		// reenvia a la pagina
		request.getRequestDispatcher("crudDistritoDelivery.jsp").forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso listar");

		ArrayList<DistritoDelivery> lista = new GestionDistritoDelivery().listado();

		// enviar el listado al jsp --> atributo
		request.setAttribute("lstProductos", lista);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("listado.jsp").forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ingreso al proceso eliminar");

		int idDistrito = Integer.parseInt(request.getParameter("txtCodigo"));

		System.out.println(idDistrito);

		GestionDistritoDelivery gd = new GestionDistritoDelivery();
		int ok = gd.eliminar(idDistrito);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al eliminar!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Distrito eliminado</div>");

		}
		request.getRequestDispatcher("crudDistritoDelivery.jsp").forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ingreso al proceso actualizar");

		int idDistrito = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombreDistrito = request.getParameter("txtNombre");
		int estado = Integer.parseInt(request.getParameter("cboEstado"));
		
		DistritoDelivery d = new DistritoDelivery(idDistrito, nombreDistrito, estado);

		GestionDistritoDelivery gd = new GestionDistritoDelivery();
		int ok = gd.actualizar(d);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al actualizar!!!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Distrito actualizado</div>");

		}
		request.getRequestDispatcher("crudDistritoDelivery.jsp").forward(request, response);

		System.out.println(idDistrito + " " + nombreDistrito);

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ingreso al proceso registrar");

		int idDistrito = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombreDistrito = request.getParameter("txtNombre");
		int estado = Integer.parseInt(request.getParameter("cboEstado"));
			
		DistritoDelivery d = new DistritoDelivery(idDistrito, nombreDistrito, estado);

		GestionDistritoDelivery gd = new GestionDistritoDelivery();
		int ok = gd.registrar(d);

		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al registrar!</div>");

		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Distrito registrado</div>");

		}
		request.getRequestDispatcher("crudDistritoDelivery.jsp").forward(request, response);
		
		System.out.println(idDistrito + " " + nombreDistrito +  " " + estado);

	}

	

}
