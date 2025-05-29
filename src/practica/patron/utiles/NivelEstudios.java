package practica.patron.utiles;




public enum NivelEstudios {
	
	SIN_ESTUDIOS("Sin estudios"),
	EDUCACION_PRIMARIA("Educación Primaria"),
	EDUCACION_SECUNDARIA("Educación Secundaria"),
	BACHILLERATO("Bachillerato"),
	FP_MEDIO("Formación Profesional de Grado Medio"),
	FP_SUPERIOR("Formación Profesional de Grado Superior"),
	TITULACION_UNIVERSITARIA("Titulación Universitaria"),
	MASTER_UNIVERSITARIO("Máster Universitario"),
	DOCTORADO("Doctorado");
	
	
	
	
	private final String descripcion;
	
	private NivelEstudios(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getListadoEnumerado() {
		
		StringBuilder resultado = new StringBuilder();
		NivelEstudios[] niveles = NivelEstudios.values();
		
		for (int i = 0; i < niveles.length; i++) {
			
			NivelEstudios nivel = niveles[i];
			resultado.append("(")
				.append(i + 1)
				.append(") ")
				.append(nivel.getDescripcion());
			
			if (i < niveles.length - 1) {
				resultado.append(", ");
			}
		}
		
		return resultado.toString();
		
	}
	
}
