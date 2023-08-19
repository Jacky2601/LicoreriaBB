package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface CatalogoInterface {

	ArrayList<Producto> listarVino();
	ArrayList<Producto> listarWhisky();
	ArrayList<Producto> listarTequila();
	ArrayList<Producto> listarRon();
	ArrayList<Producto> listarChampange();
	ArrayList<Producto> listarVodka();
	ArrayList<Producto> listarGin();
	ArrayList<Producto> listarPisco();
	ArrayList<Producto> listarOtros();
	
	Producto buscarIDS(int id_producto);
	ArrayList<Producto> listaProducto();
	
}
