package interfaces;

import java.util.ArrayList;
import model.Producto;

public interface ProductoInterface {
	
	// Método para buscar un producto por su id_producto
    public Producto buscarProductoPorId(int id_producto);
    
    
	// Método para insertar un nuevo producto en la base de datos
	public int agregarProducto(Producto producto);
	
	//Metodo para listar todos los productos
	ArrayList<Producto> listarProducto();
	
	//Metodo para actualizar un producto en la base de datos
	public int actualizarProducto(Producto producto);
	
	//Metodo para eliminar un producto de la base de datos
	public int eliminarProducto(int id_producto);
	
		
}
