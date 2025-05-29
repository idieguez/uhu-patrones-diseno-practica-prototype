package practica.patron.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

import practica.patron.dominio.Persona;
import practica.patron.dominio.PersonaClonable;
import practica.patron.utiles.NivelEstudios;




public class Main {
    
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_ROJO = "\u001B[31m";
    private static final String COLOR_SUBR_ROJO = "\u001B[41m";

    private static final String ADMIN_USUARIO = "admin";
    private static final String ADMIN_CONTRASENA = "admin";
    
    private static List<PersonaClonable> personas = new ArrayList<>();
    
    
    
    
    
    
	
	
	
	
	public static void main(String[] args) {
		
		// Atributos.
		boolean cargaInicialOk = false;
		
		
		// Carga inicial.
		cargaInicialOk = cargaInicial();
		
		if (!cargaInicialOk) {
			System.out.println("Ha ocurrido un error durante el proceso de carga inicial de los datos. Se cancela la ejecución del programa.");
			return;
		}
		
		
		// Ejecución del programa.
		ejecucionPrograma();
        
    }
	
	
	
	
	
	
	
	
	
    
	private static boolean cargaInicial() {
		
		boolean resultado = false;
		
		
		try {
			
			PersonaClonable persona1 = new Persona(
					"Severo", "Ochoa de Albornoz", "Plaza de San Francisco 2", 41004, "Sevilla", "Sevilla",
					"954000001", "600000001", "severo@example.com", NivelEstudios.TITULACION_UNIVERSITARIA);
			personas.add(persona1);
			
			PersonaClonable persona2 = new Persona(
					"Juana", "I de Castilla", "Plaza del Salvador 3", 41004, "Sevilla", "Sevilla",
					"954000002", "600000011", "juana@example.com", NivelEstudios.MASTER_UNIVERSITARIO);
			personas.add(persona2);
			
			PersonaClonable persona3 = new Persona(
					"Miguel", " de Cervantes Saavedra", "Calle Sierpes 1", 41004, "Sevilla", "Sevilla",
					"954000003", "600000021", "miguel@example.com", NivelEstudios.FP_SUPERIOR);
			personas.add(persona3);
			
			resultado = true;
			
		} catch(Exception e) {
			resultado = false;
		}
		
		
		return resultado;
		
	}
	
	
	
	
	
	
	
	
	
	
	private static void ejecucionPrograma() {

        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 1;
        int opcionSeleccion;
        int opcionMix;
        
		System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--  COLEGIO DE ADMINISTRADORES DE FINCAS DE SEVILLA                                                                   --");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        
        System.out.println("");
        System.out.println("Bienvenido al Colegio de Administradores de Fincas de Sevilla.");
        System.out.println("Espere mientras conectamos con el servidor...");
        LockSupport.parkNanos(2_000_000_000L);
        
        System.out.println("");
        System.out.println(COLOR_SUBR_ROJO + "[Esta es una aplicación de uso académico.]" + COLOR_RESET);
        System.out.println(COLOR_SUBR_ROJO + "[Para conocer las credenciales de usuario para las pruebas, consulte la documentación.]" + COLOR_RESET);
        System.out.println("");
        
        do {
        	
        	
        	
        	
        	// Mostrar menú.
        	switch (opcionMenu) {
            
	            // 1. De login.
	            case 1:
	            	System.out.println("Seleccione una opción del menú:");
	            	System.out.println("");
	            	System.out.println("1. Iniciar sesión.");
	            	System.out.println("");
	                System.out.println("0. Salir.");
	                System.out.println("");
	            	break;
	            	
            	// 2. De administración.
	            case 2:
	            	System.out.println("Seleccione una opción del menú:");
	            	System.out.println("");
	            	System.out.println("1. Visualizar usuarios dados de alta.");
	            	System.out.println("2. Añadir usuario al sistema.");
	            	System.out.println("3. Eliminar usuario del sistema.");
	            	System.out.println("");
	            	System.out.println("9. Cerrar sesión.");
	                System.out.println("");
	            	break;
            	
        	}
        	
        	System.out.print("Selección: ");
        	opcionSeleccion = scanner.nextInt();
            scanner.nextLine();																					// Limpiar el buffer.
            System.out.println("");
        	
        	opcionMix = Integer.parseInt(opcionMenu + "" + opcionSeleccion);
        	
        	
        	
        	
        	// Mostrar siguiente nivel del menú.
            switch (opcionMix) {
                
            	
                // 11: Iniciar sesión.
                case 11:
                    System.out.println("Iniciar sesión.");
                    System.out.println("");
                    System.out.println("Introduzca sus credenciales de acceso.");
                    System.out.print  ("· Nombre de usuario: ");
                    String nombreUsuarioLogin = scanner.nextLine();
                    System.out.print  ("· Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();
                    System.out.println("");
                    
                    if (nombreUsuarioLogin.equals(ADMIN_USUARIO) && contrasenaLogin.equals(ADMIN_CONTRASENA)) {
                    	opcionMenu = 2;
                        System.out.println("Ha iniciado sesión correctamente.");
                        System.out.println("");
                        
                    } else {
                    	System.out.println("Sus credenciales no son válidas.");
                        System.out.println("");
                    }
                    
                    break;
                	
                	
            	// 21: Visualizar usuarios dados de alta.
                case 21:
                	System.out.println("Visualizar usuarios dados de alta.");
                    System.out.println("");
                    
                    visualizarUsuarios();
                    
                    System.out.println("");
                    
                	break;
                	
                	
            	// 22: Añadir usuario al sistema.
                case 22:
                	System.out.println("Añadir usuario al sistema.");
                    System.out.println("");
                    
                    System.out.print  ("¿Desea añadir (1) un nuevo usuario al sistema, o (2) hacerlo a partir de un familiar? ");
                    int opcionUsuarioAnadir = scanner.nextInt();
                    scanner.nextLine();																			// Limpiar el buffer.
                    System.out.println("");
                    
                    switch (opcionUsuarioAnadir) {
                    	
	                    case 1:
	                    	PersonaClonable persona1 = new Persona();
	                    	
                        	System.out.print  ("· Nombre: ");
                            String nombre1 = scanner.nextLine();
                        	
                            System.out.print  ("· Apellidos: ");
                            String apellidos1 = scanner.nextLine();
                        	
                            System.out.print  ("· Dirección: ");
                            String direccion1 = scanner.nextLine();
                        	
                            System.out.print  ("· Código Postal: ");
                            int codigoPostal1 = scanner.nextInt();
                            scanner.nextLine();																		// Limpiar el buffer.
                        	
                            System.out.print  ("· Localidad: ");
                            String localidad1 = scanner.nextLine();
                        	
                            System.out.print  ("· Provincia: ");
                            String provincia1 = scanner.nextLine();
                        	
                            System.out.print  ("· Teléfono Fijo: ");
                            String telefonoFijo1 = scanner.nextLine();
                        	
                            System.out.print  ("· Teléfono Móvil: ");
                            String telefonoMovil1 = scanner.nextLine();
                        	
                            System.out.print  ("· Correo Electrónico: ");
                            String correoElectronico1 = scanner.nextLine();
                            
                            // System.out.print  ("· Nivel de Estudios: " + NivelEstudios.getListadoEnumerado());
                            System.out.println("· Nivel de Estudios:");
                            for (int i = 0; i < NivelEstudios.values().length; i++) {
                            	System.out.println("    (" + (i + 1) + ") " + NivelEstudios.values()[i].getDescripcion() + ".");
                            }
                            
                            System.out.print  ("· Nivel de Estudios: ");
                            int iNivelEstudios1 = scanner.nextInt();
                            scanner.nextLine();																		// Limpiar el buffer.
                            System.out.println("");
                            
                            NivelEstudios[] niveles1 = NivelEstudios.values();
                            NivelEstudios nivelEstudios1 = null;
                            
                            if (iNivelEstudios1 > 0 && iNivelEstudios1 <= niveles1.length) {
                            	nivelEstudios1 = niveles1[iNivelEstudios1 - 1];
                            	
                            	persona1.setNombre(nombre1);
                            	persona1.setApellidos(apellidos1);
                            	persona1.setDireccion(direccion1);
                            	persona1.setCodigoPostal(codigoPostal1);
                            	persona1.setLocalidad(localidad1);
                            	persona1.setProvincia(provincia1);
                            	persona1.setTelefonoFijo(telefonoFijo1);
                            	persona1.setTelefonoMovil(telefonoMovil1);
                            	persona1.setCorreoElectronico(correoElectronico1);
                            	persona1.setNivelEstudios(nivelEstudios1);
                            	
                            	boolean personaAnadida = personas.add(persona1);
                            	
                            	if (personaAnadida) {
	                            	System.out.println("Usuario añadido.");
		                            System.out.println("");
                            	} else {
                            		System.out.println("Usuario no añadido por haber ocurrido un error.");
		                            System.out.println("");
                            	}
                            	
                            } else {
	                        	System.out.println("Selección inválida.");
	                            System.out.println("");
	                        }
	                    	
	                    	break;
	                    	
	                    case 2:
	                    	visualizarUsuarios();
	                        
	                        System.out.println("");
	                        System.out.print  ("Seleccione el familiar del nuevo usuario a añadir: ");
	                        int iFamiliar = scanner.nextInt();
	                        scanner.nextLine();																			// Limpiar el buffer.
	                        System.out.println("");
	                        
	                        if (iFamiliar > 0 && iFamiliar <= personas.size()) {
	                        	PersonaClonable persona2 = personas.get(iFamiliar - 1).clonar();
	                        	
	                        	System.out.print  ("· Nombre: ");
	                            String nombre2 = scanner.nextLine();
	                        	
	                            System.out.print  ("· Apellidos: ");
	                            String apellidos2 = scanner.nextLine();
	                        	
	                            System.out.print  ("· Teléfono Móvil: ");
	                            String telefonoMovil2 = scanner.nextLine();
	                        	
	                            System.out.print  ("· Correo Electrónico: ");
	                            String correoElectronico2 = scanner.nextLine();
	                            
	                            // System.out.print  ("· Nivel de Estudios: " + NivelEstudios.getListadoEnumerado());
	                            System.out.println("· Nivel de Estudios:");
	                            for (int i = 0; i < NivelEstudios.values().length; i++) {
	                            	System.out.println("    (" + (i + 1) + ") " + NivelEstudios.values()[i].getDescripcion() + ".");
	                            }
	                            
	                            System.out.print  ("· Nivel de Estudios: ");
	                            int iNivelEstudios2 = scanner.nextInt();
	                            scanner.nextLine();																		// Limpiar el buffer.
	                            System.out.println("");
	                            
	                            NivelEstudios[] niveles2 = NivelEstudios.values();
	                            NivelEstudios nivelEstudios2 = null;
	                            
	                            if (iNivelEstudios2 > 0 && iNivelEstudios2 <= niveles2.length) {
	                            	nivelEstudios2 = niveles2[iNivelEstudios2 - 1];
	                            	
	                            	persona2.setNombre(nombre2);
	                            	persona2.setApellidos(apellidos2);
	                            	persona2.setTelefonoMovil(telefonoMovil2);
	                            	persona2.setCorreoElectronico(correoElectronico2);
	                            	persona2.setNivelEstudios(nivelEstudios2);
	                            	
	                            	boolean personaAnadida = personas.add(persona2);
	                            	
	                            	if (personaAnadida) {
		                            	System.out.println("Usuario añadido.");
			                            System.out.println("");
	                            	} else {
	                            		System.out.println("Usuario no añadido por haber ocurrido un error.");
			                            System.out.println("");
	                            	}
	                            	
	                            } else {
		                        	System.out.println("Selección inválida.");
		                            System.out.println("");
		                        }
	                        	
	                        } else {
	                        	System.out.println("Selección inválida.");
	                            System.out.println("");
	                        }
	                            
	                    	break;
	                    	
	                    default:
	                    	System.out.println("Selección inválida.");
	                        System.out.println("");
                    }
                    
                	break;
                	
                	
            	// 23: Eliminar usuario del sistema.
                case 23:
                	System.out.println("Eliminar usuario del sistema.");
                    System.out.println("");
                    
                    visualizarUsuarios();
                    
                    System.out.println("");
                    System.out.print  ("Seleccione qué usuario desea eliminar del sistema: ");
                    int iEliminar = scanner.nextInt();
                    scanner.nextLine();																			// Limpiar el buffer.
                    System.out.println("");
                    
                    if (iEliminar > 0 && iEliminar <= personas.size()) {
                    	personas.remove(iEliminar - 1);
                    	System.out.println("El usuario ha sido eliminado.");
                        System.out.println("");
                    	
                    } else {
                    	System.out.println("Selección inválida.");
                        System.out.println("");
                    }
                    
                	break;
                	
                	
                // 29: Cerrar sesión.
                case 29:
                	System.out.println("Cerrando sesión...");
                    LockSupport.parkNanos(2_000_000_000L);
                    opcionMenu = 1;
                    
                    System.out.println("Sesión cerrada.");
                    System.out.println("");
                    
                	break;
                    
                	
                // 10: Salir.
                case 10:
                    System.out.println("Gracias por visitar el Colegio de Administradores de Fincas de Sevilla.");
                    LockSupport.parkNanos(2_000_000_000L);
                    System.out.println("");
                    
                    opcionMenu = 1;
                    
                    break;
                    
                    
                default:
                    System.out.println("Selección inválida. Inténtelo de nuevo.");
                    System.out.println("");
                    
                    
            }
            
        } while (opcionMix != 10);
        
        scanner.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	private static void visualizarUsuarios() {
		
		int iVisualizar = 1;
		
		for (PersonaClonable persona : personas) {
        	System.out.println("· Usuario " + String.format("%02d", iVisualizar) + " [" + persona.getResumen() + "].");
        	iVisualizar++;
        }
		
	}
	
	
}
