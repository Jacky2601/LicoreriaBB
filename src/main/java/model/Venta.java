package model;
import java.sql.Date;

public class Venta {
	
	int id_venta;
	Date fecha;
	String nombre;
	String apellido;
	String celular;
	String dni;
	String direccion;
	String observaciones;
	int idDistrito;
	String metodo_pago;
	
	@Override
	public String toString() {
		return "Venta [id_venta=" + id_venta + ", fecha=" + fecha + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", celular=" + celular + ", dni=" + dni + ", direccion=" + direccion + ", observaciones="
				+ observaciones + ", idDistrito=" + idDistrito + ", metodo_pago=" + metodo_pago + "]";
	}

	public Venta() {
		
	}

	public Venta(int id_venta, Date fecha, String nombre, String apellido, String celular, String dni, String direccion,
			String observaciones, int idDistrito, String metodo_pago) {
		super();
		this.id_venta = id_venta;
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.dni = dni;
		this.direccion = direccion;
		this.observaciones = observaciones;
		this.idDistrito = idDistrito;
		this.metodo_pago = metodo_pago;
	}
	
	

	public Venta(Date fecha, String nombre, String apellido, String celular, String dni, String direccion,
			String observaciones, int idDistrito, String metodo_pago) {
		super();
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.dni = dni;
		this.direccion = direccion;
		this.observaciones = observaciones;
		this.idDistrito = idDistrito;
		this.metodo_pago = metodo_pago;
	}
	
	

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	
	

}
