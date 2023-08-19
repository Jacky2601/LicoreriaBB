package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionDetalleVenta;
import mantenimiento.GestionDistritoDelivery;
import mantenimiento.GestionProducto;
import mantenimiento.GestionVenta;
import model.DetalleVenta;
import model.Producto;
import model.Venta;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Servlet implementation class VentaServlet
 */

@WebServlet(name = "venta", description = "Controlador para la venta", urlPatterns = { "/venta" }) 

public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//GestionVenta adminVenta=new GestionVenta();
	//GestionDetalleVenta adminDetalleVenta=new GestionDetalleVenta();
	private ArrayList<Producto> listaProducto = new ArrayList<>();
	private ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();
	private Integer idDistrito = 0;
	
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso al Servlet de Venta");

		String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";
		System.out.println("Opcion seleccionada en el boton: " + accion);
		
		switch (accion) {
		case "nuevo":
			nuevaVenta(request, response);
			break;
			
		case "agregar":
			agregar(request, response);
			break;
			
		case "registrar":
			registrar(request, response);
			break;

		default:
			nuevaVenta(request, response);
			break;
		}
	}

	
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Date fechaVenta = Date.valueOf(request.getParameter("fechaVenta")); String
		 * nombreCliente = request.getParameter("nombreCliente"); String apellidoCliente
		 * = request.getParameter("apellidoCliente"); String celularCliente =
		 * request.getParameter("celularCliente"); String dniCliente =
		 * request.getParameter("dniCliente"); String direccionCliente =
		 * request.getParameter("direccionCliente"); String observaciones =
		 * request.getParameter("observaciones"); int idDistrito =
		 * Integer.parseInt(request.getParameter("idDistrito")); String metodo_pago =
		 * request.getParameter("metodo_pago");
		 */
		
		Venta objVenta = new Venta();
		objVenta.setIdDistrito(idDistrito);
						
		GestionVenta gv = new GestionVenta();
		int idVentaResp = gv.registrarVenta(objVenta);
		
		
		
	
	    GestionDetalleVenta gdv = new GestionDetalleVenta();

	        for (DetalleVenta obj : listaDetalleVenta) {
	            obj.setId_venta(idVentaResp);
	            gdv.registrarDetalleVenta(obj);
	
		}
		
		GestionProducto producto = new GestionProducto();		
				
		request.setAttribute("productos", producto.listado());
		
				
		listaDetalleVenta = new ArrayList();
		request.setAttribute("listaDetalles", listaDetalleVenta);
		
		request.setAttribute("mensaje", "ok");
		
		request.getRequestDispatcher("venta.jsp").forward(request, response);
		
	}

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ventaId = Integer.parseInt(request.getParameter("venta"));
		int productoId = Integer.parseInt(request.getParameter("producto"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double subtotal = Double.parseDouble(request.getParameter("subtotal"));
		idDistrito = Integer.parseInt(request.getParameter("distrito"));
						
		GestionProducto producto = new GestionProducto();
		
		GestionDistritoDelivery distrito = new GestionDistritoDelivery();
				
		Producto productoObj = producto.buscar(productoId);
						
		DetalleVenta objDetalle = new DetalleVenta();
				
		objDetalle.setId_venta(ventaId);
		objDetalle.setId_producto(productoObj.getId_producto());
		objDetalle.setCantidad(cantidad);
		objDetalle.setSubtotal(subtotal);
		
		listaDetalleVenta.add(objDetalle);
		
		/*
		 * idDistrito = Integer.parseInt(request.getParameter("distrito"));
		 * GestionProducto producto = new GestionProducto(); GestionDistritoDelivery
		 * distrito = new GestionDistritoDelivery();
		 */
		
	    request.setAttribute("productos", producto.listado());
		request.setAttribute("distritos", distrito.listado());
		request.setAttribute("listaDetalles", listaDetalleVenta);
		
		request.getRequestDispatcher("venta.jsp").forward(request, response);
		
	}

	private void nuevaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionProducto producto = new GestionProducto();
		GestionDistritoDelivery distrito = new GestionDistritoDelivery();
		
		request.setAttribute("productos", producto.listado());
		request.setAttribute("distritos", distrito.listado());
		request.setAttribute("listaDetalles", listaDetalleVenta);
		
		request.getRequestDispatcher("venta.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
						
	}

	

}
