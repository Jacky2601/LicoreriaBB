package model;

public class Producto {
	private int id_producto;
	private String marca_prod;
	private int id_categoria;
	private String descripcion;
	private double precio;
	private int stock;
	private String imagen;
	
	public Producto(int id_producto, String marca_prod, int id_categoria, String descripcion, double precio, int stock,
			String imagen) {
		super();
		this.id_producto = id_producto;
		this.marca_prod = marca_prod;
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
	}

	public Producto() {
		
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	
}
