package interfaces;
import java.util.ArrayList;
import model.Producto;

public interface ProductoInterface {
	
	public int registrar(Producto p);
	public int actualizar(Producto p);
	public int eliminar(int id_producto);
	
	public ArrayList<Producto> listado();
			    
    public Producto buscar(int id_producto);
        
		
}
