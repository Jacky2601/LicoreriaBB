package interfaces;
import java.util.ArrayList;
import model.Usuario;

public interface UsuarioInterface {
	
	public Usuario validar(String usuario, String clave);
	
	public int registrar(Usuario u);
	
	public int actualizar(Usuario u);
	
	public int eliminar(int idUsuario);
	
	public ArrayList<Usuario> listado();
	
	public Usuario buscar(int idUsuario);
	
	public Usuario obtenerUsuarioPorId(int idUsuario);
	

}
