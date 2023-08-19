package model;

import java.sql.Date;

public class DetalleVenta {
	
	int id_detalleVenta;
	int id_venta;
	int id_producto;
	int cantidad;
	double subtotal;
	
	@Override
	public String toString() {
		return "DetalleVenta [id_detalleVenta=" + id_detalleVenta + ", id_venta=" + id_venta + ", id_producto="
				+ id_producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}
	

	public DetalleVenta() {
		
	}


	public DetalleVenta(int id_detalleVenta, int id_venta, int id_producto, int cantidad, double subtotal) {
		super();
		this.id_detalleVenta = id_detalleVenta;
		this.id_venta = id_venta;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


	public int getId_detalleVenta() {
		return id_detalleVenta;
	}


	public void setId_detalleVenta(int id_detalleVenta) {
		this.id_detalleVenta = id_detalleVenta;
	}


	public int getId_venta() {
		return id_venta;
	}


	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}


	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
