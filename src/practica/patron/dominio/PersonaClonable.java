package practica.patron.dominio;

import practica.patron.utiles.NivelEstudios;




public interface PersonaClonable {
	
	public String getNombre();
    public void setNombre(String nombre);
    
    public String getApellidos();
    public void setApellidos(String apellidos);
    
    public String getDireccion();
    public void setDireccion(String direccion);
    
    public int getCodigoPostal();
    public void setCodigoPostal(int codigoPostal);
    
    public String getLocalidad();
    public void setLocalidad(String localidad);
    
    public String getProvincia();
    public void setProvincia(String provincia);
    
    public String getTelefonoFijo();
    public void setTelefonoFijo(String telefonoFijo);
    
    public String getTelefonoMovil();
    public void setTelefonoMovil(String telefonoMovil);
    
    public String getCorreoElectronico();
    public void setCorreoElectronico(String correoElectronico);
    
    public NivelEstudios getNivelEstudios();
    public void setNivelEstudios(NivelEstudios nivelEstudios);
    
    public String getResumen();
    
    public PersonaClonable clonar();
	
}
