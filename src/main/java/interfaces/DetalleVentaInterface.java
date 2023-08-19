package interfaces;

import java.util.ArrayList;

import model.DetalleVenta;

public interface DetalleVentaInterface {
	
	int registrarDetalleVenta(DetalleVenta detalleVenta);
	DetalleVenta leerDetalleVenta(int id_detalleVenta);
    int actualizarDetalleVenta(DetalleVenta detalleVenta);
    int eliminarDetalleVenta(int id_detalleVenta);
    ArrayList<DetalleVenta> listarDetalleVenta();

}
