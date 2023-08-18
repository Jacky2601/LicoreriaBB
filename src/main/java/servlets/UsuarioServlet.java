package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionDistritoDelivery;
import mantenimiento.GestionUsuario;
import model.DistritoDelivery;
import model.Usuario;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class UsuarioServlet
 */

@WebServlet(name = "crudUsuario", description = "Controlador para el usuario", urlPatterns = { "/crudUsuario" })

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Servlet de Usuario");

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
			
		case "obtener":
			obtenerDatosPorId(request, response);
			break;

		default:
			break;
		}
	}
	
	

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingresó al proceso de registrar usuario...");
		
		String nombre, apellidoPat, apellidoMat, usuario, clave; 
		int tipo;
		
		// Para los datos del registro de cuenta
		nombre = request.getParameter("txtNombre");
		apellidoPat = request.getParameter("txtApellidoPat");
		apellidoMat = request.getParameter("txtApellidoMat");
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtPassword");
		tipo = Integer.parseInt(request.getParameter("cboTipo"));
				
		if (nombre == null || apellidoPat == null || apellidoMat == null || usuario == null || clave == null || tipo == -1) {
	        // Manejar el error o redireccionar a una página de error
	        response.sendRedirect("manteUsuarios.jsp");
	        return;
	    }
		
	
		Usuario u = new Usuario(nombre, apellidoPat,apellidoMat,usuario, clave, tipo);
		GestionUsuario gu = new GestionUsuario();
		int ok = gu.registrar(u);
				    
		    
		    if (ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al registrar usuario!</div>");

			} else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Se registro el usuario exitosamente</div>");

			}
			request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);
			
			
			System.out.println(nombre + " " + apellidoPat + " " + apellidoMat + " " + usuario + " " + clave + " " + tipo);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingreso al proceso actualizar usuario");
		
            int idUsuario = Integer.parseInt(request.getParameter("txtCodigo"));
            String nombre = request.getParameter("txtNombre"); 
            String apellidoPat = request.getParameter("txtApellidoPat");
            String apellidoMat = request.getParameter("txtApellidoMat");
            String usuario = request.getParameter("txtUsuario");
    		String clave = request.getParameter("txtPassword");
    		int tipo = Integer.parseInt(request.getParameter("cboTipo"));
    		                  
            
            Usuario u = new Usuario(idUsuario, nombre, apellidoPat, apellidoMat, usuario, clave, tipo);

            GestionUsuario gu = new GestionUsuario();
            int ok = gu.actualizar(u);
            
            if (ok == 0) {
    			request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al actualizar el usuario!!!</div>");

    		} else {
    			request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Usuario actualizado</div>");

    		}
    		request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);

    		System.out.println(idUsuario + " " + nombre + " " + apellidoPat + " " + apellidoMat + " " + usuario + " " + clave + " " + tipo);

							
	}

	private void obtenerDatosPorId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    int idUsuario = Integer.parseInt(request.getParameter("txtCodigo")); // Obtener el ID de usuario de la solicitud
	    
	    GestionUsuario gu = new GestionUsuario();
	    Usuario u = gu.obtenerUsuarioPorId(idUsuario);
	    
	    request.setAttribute("u", u);
        request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);
	    	        
	}
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("ingreso al proceso eliminar");

			int idUsuario = Integer.parseInt(request.getParameter("txtCodigo"));

			System.out.println(idUsuario);

			GestionUsuario gu = new GestionUsuario();
			int ok = gu.eliminar(idUsuario);

			if (ok == 0) {
				request.setAttribute("mensaje", "<div class='alert alert-danger' role='alert'>Error al eliminar!</div>");

			} else {
				request.setAttribute("mensaje", "<div class='alert alert-success' role='alert'>Usuario eliminado</div>");

			}
			request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ingreso al proceso listar usuario");
				
		GestionUsuario gu = new GestionUsuario();
		ArrayList<Usuario> listado = gu.listado(); 

		// enviar el listado al jsp --> atributo
		request.setAttribute("listado", listado);

		// redireccionando a la pagina listado
		request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// leer el codigo del usuario a buscar
		int idUsuario = Integer.parseInt(request.getParameter("txtCodigo"));

		// obtener la informacion del usuario, usando la clase gestion
		Usuario u = new GestionUsuario().buscar(idUsuario);

		// enviar el obj de usuario como atributo a la pagina
		request.setAttribute("u", u);

		// reenvia a la pagina
		request.getRequestDispatcher("manteUsuarios.jsp").forward(request, response);
		
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
