package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionUsuario;
import model.Usuario;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(name = "crudUsu", description = "Controlador para el usuario", urlPatterns = { "/crudUsu" })

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        
     // Metodo general --> post/get
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet del Login del Usuario");

		String accion = request.getParameter("btnAccion");
		System.out.println("Opcion seleccionada en el boton: " + accion);

		switch (accion) {
		case "registrar":
			registrar(request, response);
			break;
		case "login":
			login(request, response);
			break;

		default:
			break;
		}
	}
	
	
	

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Entro a la opcion Login...");

		String usuario, password;

		usuario = request.getParameter("txtUsuario");
		password = request.getParameter("txtPassword");
		
		GestionUsuario gu = new GestionUsuario();
		Usuario u = gu.validar(usuario, password);
		
		
		if (u != null) {
			
			System.out.println("Usuario correcto. Bienvenido!!!");
			
			request.getSession().setAttribute("u", u); // el atributo esta a nivel de sesion
			
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		

	    } else {
			System.out.println("Usuario o clave incorrecto");
			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>\r\n"
					+ "  Usuario o contraseña incorrectos!\r\n" + "</div>");
			// este es una forma de mostrar un mesaje (en este caso flotante
			// "<script>alert('Usuario o contraseña incorrecto')</script>");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("Ingresó al proceso de registrar cuenta...");
		
		// Para los datos del registro de cuenta
		String nombre = request.getParameter("txtNombre");
		String apellidoPat = request.getParameter("txtApellidoPat");
		String apellidoMat = request.getParameter("txtApellidoMat");
		String usuario = request.getParameter("txtUsuario");
		String password = request.getParameter("txtPassword");

		System.out.println(nombre + " " + apellidoPat + " " + apellidoMat + " " + usuario + " " + password);
		
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
