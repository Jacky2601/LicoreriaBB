package model;

public class DistritoDelivery {
	
	private int idDistrito;
	private String nombreDistrito;
	private int estado;
	
	

	@Override
	public String toString() {
		return "DistritoDelivery [idDistrito=" + idDistrito + ", nombreDistrito=" + nombreDistrito + ", estado="
				+ estado + "]";
	}


	public DistritoDelivery() {
		
	}
		

	public DistritoDelivery(int idDistrito, String nombreDistrito) {
		super();
		this.idDistrito = idDistrito;
		this.nombreDistrito = nombreDistrito;
	}

	public DistritoDelivery(int idDistrito, String nombreDistrito, int estado) {
		this.idDistrito = idDistrito;
		this.nombreDistrito = nombreDistrito;
		this.estado = estado;
	}

	public DistritoDelivery(String nombreDistrito, int estado) {
		super();
		this.nombreDistrito = nombreDistrito;
		this.estado = estado;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
