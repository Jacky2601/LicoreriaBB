package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import mantenimiento.GestionProducto;
import model.Producto;

public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Obtener la acción que se va a realizar (agregar, actualizar, eliminar, buscar o seleccionar)
    String action = request.getParameter("action");
    GestionProducto gestionProducto = new GestionProducto();

    if (action != null) {
        switch (action) {
            case "agregar":
            	// Obtener los datos del formulario
                int idProducto = Integer.parseInt(request.getParameter("id_producto"));
                String marcaProd = request.getParameter("marca_prod");
                int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
                String descripcion = request.getParameter("descripcion");
                double precio = Double.parseDouble(request.getParameter("precio"));
                int stock = Integer.parseInt(request.getParameter("stock"));
                String imagen = request.getParameter("imagen");

                // Crear el objeto Producto
                Producto producto = new Producto(idProducto, marcaProd, idCategoria, descripcion, precio, stock, imagen);

                // Agregar el producto a la base de datos
                gestionProducto.agregarProducto(producto);
                break;

            case "actualizar":
            	// Obtener los datos del formulario
                int idProductoActualizar = Integer.parseInt(request.getParameter("id_producto"));
                String marcaProdActualizar = request.getParameter("marca_prod");
                int idCategoriaActualizar = Integer.parseInt(request.getParameter("id_categoria"));
                String descripcionActualizar = request.getParameter("descripcion");
                double precioActualizar = Double.parseDouble(request.getParameter("precio"));
                int stockActualizar = Integer.parseInt(request.getParameter("stock"));
                String imagenActualizar = request.getParameter("imagen");

                // Crear el objeto Producto
                Producto productoActualizar = new Producto(idProductoActualizar, marcaProdActualizar, idCategoriaActualizar, descripcionActualizar, precioActualizar, stockActualizar, imagenActualizar);

                // Actualizar el producto en la base de datos
                gestionProducto.actualizarProducto(productoActualizar);
                break;

            case "eliminar":
            	 int idProductoEliminar = Integer.parseInt(request.getParameter("id_producto"));
                 // Eliminar el producto de la base de datos
                 gestionProducto.eliminarProducto(idProductoEliminar);
                 break;
                 
                 case "buscar":
                     // Obtener el id_producto a buscar
                     int idProductoBuscar = Integer.parseInt(request.getParameter("id_producto"));

                     // Buscar el producto en la base de datos
                     Producto productoBuscado = gestionProducto.buscarProductoPorId(idProductoBuscar);
                     
                     // Redireccionar a una página para mostrar los detalles del producto
                     request.setAttribute("productoBuscado", productoBuscado);
                     request.getRequestDispatcher("mostrarProducto.jsp").forward(request, response);
                     return; // Se utiliza 'return' para evitar la redirección a la lista de productos
             
           
            
            case "seleccionar":
                // Obtener el id_producto seleccionado
                int idProductoSeleccionado = Integer.parseInt(request.getParameter("id_producto_actualizar_eliminar"));
                // Buscar el producto en la base de datos
                Producto productoSeleccionado = gestionProducto.buscarProductoPorId(idProductoSeleccionado);
                // Redireccionar al formulario con la información del producto seleccionado
                request.setAttribute("productoSeleccionado", productoSeleccionado);
                request.getRequestDispatcher("ProductoServlet.jsp").forward(request, response);
                return;
        }
    }

    // Redireccionar a la lista de productos
    ArrayList<Producto> listaProductos = gestionProducto.listarProducto();
    request.setAttribute("listaProductos", listaProductos);
    request.getRequestDispatcher("ProductoServlet.jsp").forward(request, response);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
}

}
