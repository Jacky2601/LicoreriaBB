package interfaces;

import java.util.ArrayList;

import model.DistritoDelivery;

public interface DistritoDeliveryInterface {
	
	public int registrar(DistritoDelivery d);
	public int actualizar(DistritoDelivery d);
	public int eliminar(int idDistrito);
	
	public ArrayList<DistritoDelivery> listado();
	
	public DistritoDelivery buscar(int idDistrito);
	

}
