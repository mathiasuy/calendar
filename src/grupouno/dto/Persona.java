package grupouno.dto;

import java.util.Date;

public abstract class Persona {
	
	private int personaID;
	private String nombre;
	private String documento;
	private Date fecha_de_nacimiento;
	private Date fecha_registrado;
	private String comentarios;
	private String telefono;
	private String usuario;
	private String contrasena;
	private boolean habilitado;

	protected Persona(String nombre, String documento, Date fecha_de_nacimiento, Date fecha_registrado, String comentarios,
			String telefono, String usuario, String contrasena, boolean habilitado) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.fecha_registrado = fecha_registrado;
		this.comentarios = comentarios;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.habilitado = habilitado;
	}

	public int getPersonaID() {
		return personaID;
	}

	public void setPersonaID(int personaID) {
		this.personaID = personaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public Date getFecha_registrado() {
		return fecha_registrado;
	}

	public void setFecha_registrado(Date fecha_registrado) {
		this.fecha_registrado = fecha_registrado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public String toString() {
		return "Persona [personaID=" + personaID + ", nombre=" + nombre + ", documento=" + documento
				+ ", fecha_de_nacimiento=" + fecha_de_nacimiento + ", fecha_registrado=" + fecha_registrado
				+ ", comentarios=" + comentarios + ", telefono=" + telefono + ", usuario=" + usuario + ", contrasena="
				+ contrasena + ", habilitado=" + habilitado + "]";
	}
	
}
