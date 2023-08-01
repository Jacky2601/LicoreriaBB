package model;

public class Usuario {
	
	private int idUsuario;
	private String nombre;
	private String apellidoPat;
	private String apellidoMat;
	private String usuario;
	private String clave;
	private int tipo;
	private int estado;
	
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat
				+ ", apellidoMat=" + apellidoMat + ", usuario=" + usuario + ", clave=" + clave + ", tipo=" + tipo
				+ ", estado=" + estado + "]";
	}
	
	
	

	public Usuario() {
		
	}

	public Usuario(int idUsuario, String nombre, String apellidoPat, String apellidoMat, String usuario, String clave) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.usuario = usuario;
		this.clave = clave;
	}
	
	
	public Usuario(String nombre, String apellidoPat, String apellidoMat, String usuario, String clave, int tipo,
			int estado) {
		super();
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.usuario = usuario;
		this.clave = clave;
		this.tipo = tipo;
		this.estado = estado;
	}

	
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPat() {
		return apellidoPat;
	}


	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}


	public String getApellidoMat() {
		return apellidoMat;
	}


	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
		

}
