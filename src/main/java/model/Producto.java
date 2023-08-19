package model;

public class Producto {
	private int id_producto;
	private int id_categoria;
	private String categoria;
	private String marca_prod;
	private String descripcion;
	private double precio;
	private int stock;
	private int estado;
	
	
	public Producto() {
		
	}
	
//PARA CATALOGOS OJITO
	
	public Producto(int id_producto, String categoria, String marca_prod, String descripcion, double precio,
			int stock) {
		this.id_producto = id_producto;
		this.categoria = categoria;
		this.marca_prod = marca_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		}

//

	public Producto(int id_categoria, String marca_prod, String descripcion, double precio, int stock, int estado) {
		super();
		this.id_categoria = id_categoria;
		this.marca_prod = marca_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
	}



	public Producto(int id_producto, int id_categoria, String marca_prod, String descripcion, double precio, int stock,
			int estado) {
		super();
		this.id_producto = id_producto;
		this.id_categoria = id_categoria;
		this.marca_prod = marca_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
	}


	public Producto(int id_producto, int id_categoria, String categoria, String marca_prod, String descripcion,
			double precio, int stock, int estado) {
		super();
		this.id_producto = id_producto;
		this.id_categoria = id_categoria;
		this.categoria = categoria;
		this.marca_prod = marca_prod;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.estado = estado;
	}


	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getMarca_prod() {
		return marca_prod;
	}

	public void setMarca_prod(String marca_prod) {
		this.marca_prod = marca_prod;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
}
