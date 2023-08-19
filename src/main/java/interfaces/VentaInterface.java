package interfaces;

import java.util.ArrayList;

import model.Venta;

public interface VentaInterface {
	
	int registrarVenta(Venta venta);
	Venta leerVenta(int id_venta);
    int actualizarVenta(Venta venta);
    int eliminarVenta(int id_venta);
    ArrayList<Venta> listarVenta();

}
