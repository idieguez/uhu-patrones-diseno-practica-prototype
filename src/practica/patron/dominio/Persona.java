package practica.patron.dominio;

import practica.patron.utiles.NivelEstudios;




public class Persona implements PersonaClonable {
	
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected int codigoPostal;
	protected String localidad;
	protected String provincia;
	protected String telefonoFijo;
	protected String telefonoMovil;
	protected String correoElectronico;
	protected NivelEstudios nivelEstudios;
	
	
	
	
	public Persona() {
		this.nombre = null;
		this.apellidos = null;
		this.direccion = null;
		this.codigoPostal = 0;
		this.localidad = null;
		this.provincia = null;
		this.telefonoFijo = null;
		this.telefonoMovil = null;
		this.correoElectronico = null;
		this.nivelEstudios = null;
	}
	
	public Persona(String nombre, String apellidos, String direccion, int codigoPostal, String localidad, String provincia, String telefonoFijo, String telefonoMovil, String correoElectronico, NivelEstudios nivelEstudios) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.correoElectronico = correoElectronico;
		this.nivelEstudios = nivelEstudios;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getApellidos() {
		return apellidos;
	}
	
	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String getDireccion() {
		return direccion;
	}
	
	@Override
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public int getCodigoPostal() {
		return codigoPostal;
	}
	
	@Override
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Override
	public String getLocalidad() {
		return localidad;
	}
	
	@Override
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String getProvincia() {
		return provincia;
	}
	
	@Override
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	
	@Override
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	@Override
	public String getTelefonoMovil() {
		return telefonoMovil;
	}
	
	@Override
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}
	
	@Override
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	@Override
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	@Override
	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}
	
	@Override
	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}
	
	@Override
	public String getResumen() {
		
		String resumen =
			nombre + " " + apellidos + ", " + 
			direccion + " " + codigoPostal + " " + localidad + " (" + provincia + "), " +
			telefonoFijo + " / " + telefonoMovil + ", " + correoElectronico + ", " + nivelEstudios.getDescripcion();
		
		return resumen;
		
	}
	
	@Override
	public PersonaClonable clonar() {
		
		// Datos clonados: direccion, codigoPostal, localidad, provincia, telefonoFijo
		// Datos restantes: nombre, apellidos, telefonoMovil, correoElectronico, nivelEstudios
		
		PersonaClonable personaClonable = new Persona();
		personaClonable.setDireccion(direccion);
		personaClonable.setCodigoPostal(codigoPostal);
		personaClonable.setLocalidad(localidad);
		personaClonable.setProvincia(provincia);
		personaClonable.setTelefonoFijo(telefonoFijo);
        
        return personaClonable;
		
	}
	
}
