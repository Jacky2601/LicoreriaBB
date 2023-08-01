package interfaces;

import model.Usuario;

public interface UsuarioInterface {
	
public Usuario validar(String usuario, String clave);
	
	public int registrar(Usuario u);

}
