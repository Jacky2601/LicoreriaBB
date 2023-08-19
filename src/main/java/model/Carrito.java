package model;

import java.util.Objects;

public class Carrito {
	
	private Producto producto;
    private int cantidad;
    
    
    public Carrito() {
		
	}
   
	
	

    public Carrito(Producto producto, int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carrito [producto=" + producto + ", cantidad=" + cantidad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carrito other = (Carrito) obj;
        return cantidad == other.cantidad && Objects.equals(producto, other.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cantidad);
    }
	

    
    
    
}
